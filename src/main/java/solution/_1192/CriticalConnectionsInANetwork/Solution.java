package solution._1192.CriticalConnectionsInANetwork;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public class Graph {

        private int V;
        private int E;
        private ArrayList<Integer>[] adj;

        public Graph(int V){

            this.V = V;
            if(V < 0) throw new IllegalArgumentException("V must be non-negative");
            adj = new ArrayList[V];
            for(int i = 0; i < V; i ++)
                adj[i] = new ArrayList<Integer>();

            E = 0;
        }

        public void addEdge(int v, int w){

            validateVertex(v);
            validateVertex(w);

            if(adj[v].contains(w)) return;

            adj[v].add(w);
            adj[w].add(v);
            E ++;
        }

        public void validateVertex(int v){
            if(v < 0 || v >= V)
                throw new IllegalArgumentException("vertex " + v + "is invalid");
        }

        public int V(){
            return V;
        }

        public int E(){
            return E;
        }

        public Iterable<Integer> adj(int v){
            validateVertex(v);
            return adj[v];
        }
    }

    public class FindBridges {

        private Graph G;
        private boolean[] visited;

        private int ord[];
        private int low[];
        private int cnt;

        private List<List<Integer>> res;

        public FindBridges(Graph G){

            this.G = G;
            visited = new boolean[G.V()];

            res = new ArrayList<>();
            ord = new int[G.V()];
            low = new int[G.V()];
            cnt = 0;

            for(int v = 0; v < G.V(); v ++)
                if(!visited[v])
                    dfs(v, v);
        }

        private void dfs(int v, int parent){

            visited[v] = true;
            ord[v] = cnt;
            low[v] = ord[v];
            cnt ++;

            for(int w: G.adj(v))
                if(!visited[w]){
                    dfs(w, v);
                    low[v] = Math.min(low[v], low[w]);
                    if(low[w] > ord[v]){
                        ArrayList<Integer> edge = new ArrayList<>();
                        edge.add(v);
                        edge.add(w);
                        res.add(edge);
                    }
                }
                else if(w != parent)
                    low[v] = Math.min(low[v], low[w]);
        }

        public List<List<Integer>> result(){
            return res;
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Graph g = new Graph(n);
        for(List<Integer> edge: connections)
            g.addEdge(edge.get(0), edge.get(1));

        FindBridges fb = new FindBridges(g);
        return fb.result();
    }

    public static void main(String[] args) {
        // n = 2, connections = [[0,1]]

        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        connections.add(list);
        List<List<Integer>> result = new Solution().criticalConnections(2, connections);

        System.out.println(result.get(0));
    }

}
