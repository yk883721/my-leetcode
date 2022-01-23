package solution._0695.MaxAreaOfIsland;

import java.util.ArrayList;

public class Solution {

    int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    private int[][] grid;

    private int R;
    private int C;
    private boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.R = grid.length;
        this.C = grid[0].length;
        this.visited = new boolean[R][C];

        int res = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && grid[i][j] == 1){
                    res = Math.max(res, dfs(i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int x, int y){

        int res = 1;
        visited[x][y] = true;

        ArrayList<Integer> nexts = new ArrayList<>();
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (inArea(nextX, nextY) && grid[nextX][nextY] == 1 && !visited[nextX][nextY])
                res += dfs(nextX, nextY);
        }
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {

//        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
//
//        System.out.println(new Solution().maxAreaOfIsland(grid));

        System.out.println('1' - '0');
    }

}
