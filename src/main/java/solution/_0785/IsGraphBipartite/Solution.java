package solution._0785.IsGraphBipartite;

public class Solution {

    public boolean isBipartite(int[][] graph) {

        boolean[] visited = new boolean[graph.length];
        int[] colors = new int[graph.length];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = -1;
        }

        for (int v = 0; v < graph.length; v++) {
            if (!visited[v]){
                if (!dfs(v, 0, graph, visited, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int v, int color, int[][] graph, boolean[] visited, int[] colors){
        visited[v] = true;
        colors[v] = color;
        for (int w : graph[v]) {
            if (!visited[w]){
                if (!dfs(w, 1 - color, graph, visited, colors)) {
                    return false;
                }
            }else if (colors[w] == colors[v]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(new Solution().isBipartite(graph));
    }

}
