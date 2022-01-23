package solution._0547.NumberOfProvinces;

import java.util.TreeSet;

public class Solution {

    //region 解法一：quickFind
    //    public int findCircleNum(int[][] isConnected) {
//        int n = isConnected.length;
//        int[] id = new int[n];
//        for (int i = 0; i < id.length; i++) {
//            id[i] = i;
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (isConnected[i][j] == 1){
//                    int pId = id[i];
//                    int qId = id[j];
//
//                    if (pId != qId){
//                        for (int k = 0; k < id.length; k++) {
//                            if (id[k] == pId){
//                                id[k] = qId;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        TreeSet<Integer> set = new TreeSet<>();
//        for(int i = 0 ; i < n ; i ++)
//            set.add(id[i]);
//        return set.size();
//    }
    //endregion

    //region 解法二：quickUnion
//    private interface UF {
//        int getSize();
//        boolean isConnected(int p, int q);
//        void unionElements(int p, int q);
//    }
//    private class QuickUnion implements UF{
//
//        // 我们的第二版Union-Find, 使用一个数组构建一棵指向父节点的树
//        // parent[i]表示第一个元素所指向的父节点
//        private int[] parent;
//
//        public QuickUnion(int size){
//            parent = new int[size];
//            for (int i = 0; i < parent.length; i++) {
//                parent[i] = i;
//            }
//        }
//
//        @Override
//        public int getSize() {
//            return parent.length;
//        }
//
//        @Override
//        public boolean isConnected(int p, int q) {
//            int pId = find(p);
//            int qId = find(q);
//            return qId == pId;
//        }
//
//        @Override
//        public void unionElements(int p, int q) {
//            int pId = find(p);
//            int qId = find(q);
//
//            if (pId == qId){
//                return;
//            }
//            parent[pId] = qId;
//        }
//
//        private int find(int index){
//            if(index < 0 || index >= parent.length)
//                throw new IllegalArgumentException("p is out of bound.");
//            while (parent[index] != index){
//                index = parent[index];
//            }
//            return index;
//        }
//
//    }
//    public int findCircleNum(int[][] M) {
//
//        int n = M.length;
//        QuickUnion uf = new QuickUnion(n);
//        for(int i = 0 ; i < n ; i ++)
//            for(int j = 0 ; j < i ; j ++)
//                if(M[i][j] == 1)
//                    uf.unionElements(i, j);
//
//        TreeSet<Integer> set = new TreeSet<>();
//        for(int i = 0 ; i < n ; i ++)
//            set.add(uf.find(i));
//        return set.size();
//    }
    //endregion

    //region 解法三：求图的联通分量
    private boolean[] visited;
    private int[][] G;
    public int findCircleNum(int[][] M) {
        int cccount = 0;
        G = M;
        visited = new boolean[M.length];
        for (int v = 0; v < M.length; v++) {
            if (!visited[v]){
                dfs(v);
                cccount++;
            }
        }
        return cccount;
    }

    private void dfs(int v){
        visited[v] = true;
        for (int w = 0; w < G[v].length; w++) {
            if (G[v][w] == 1){
                if (!visited[w]){
                    dfs(w);
                }
            }
        }
    }
    //endregion

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(new Solution().findCircleNum(nums));
    }



}
