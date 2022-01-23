package solution._1020.NumberOfEnclaves;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0},{0, -1}};

    private int[][] grid;
    private boolean[][] visited;
    private int R;
    private int C;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        this.R = grid.length;
        this.C = grid[0].length;
        this.visited = new boolean[R][C];

        int res = 0;
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (grid[x][y] == 1 && !visited[x][y])
                    res += bfs(x, y);
            }
        }
        return res;
    }

//    private int dfs(int x, int y){
//        visited[x][y] = true;
//        int res = 1;
//
//        if (inEdge(x, y)){
//            return 0;
//        }
//
//        for (int[] dir : dirs) {
//            int nextX = x + dir[0];
//            int nextY = x + dir[1];
//            if (inArea(x, y) && grid[x][y] == 1 && !visited[x][y]){
//                int wValue = dfs(nextX, nextY);
//                if (wValue == 0){
//                    return 0;
//                }else {
//                    res += wValue;
//                }
//            }
//        }
//        return res;
//    }

    private int bfs(int x, int y){
        boolean hasEdge = false;
        int res = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x * C + y);
        visited[x][y] = true;

        while (!queue.isEmpty()){
            Integer v = queue.remove();
            int r = v / C;
            int c = v % C;
            if (inEdge(r, c)){
                hasEdge = true;
            }
            res ++;
            for (int[] dir : dirs) {
                int nextX = r + dir[0];
                int nextY = c + dir[1];
                if (inArea(nextX, nextY) && grid[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    queue.add(nextX * C + nextY);
                    visited[nextX][nextY] = true;
                }
            }
        }

        return hasEdge ? 0 : res;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    private boolean inEdge(int x, int y){
        return x == 0 || x == R - 1 || y == 0 || y == C - 1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(new Solution().numEnclaves(grid));
    }


}
