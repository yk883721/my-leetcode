package solution._0827.MakingALargeIsland;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    private int[][] grid;
    private int N;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        this.N = grid.length;

        int[] area = new int[N * N + 2];
        int index = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1){
                    area[index] = dfs(i, j, index++);
                }
            }
        }
        int ans = 0;
        for (int x : area) {
            ans = Math.max(ans, x);
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 0){
                    Set<Integer> seen = new HashSet<>();
                    for (int[] dir : dirs) {
                        int nextX = r + dir[0];
                        int nextY = c + dir[1];

                        if (inArea(nextX, nextY) && grid[nextX][nextY] > 1){
                            seen.add(grid[nextX][nextY]);
                        }
                    }
                    int bns = 1;
                    for (Integer inx : seen) {
                        bns += area[inx];
                    }

                    ans = Math.max(ans, bns);
                }
            }
        }

        return ans;
    }

    private int dfs(int x, int y, int index){

        grid[x][y] = index;
        int res = 1;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (inArea(nextX, nextY) && grid[nextX][nextY] == 1){
                res += dfs(nextX, nextY, index);
            }
        }

        return res;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][] {{1, 1}, {1, 1}};
        System.out.println(new Solution().largestIsland(grid));

    }

}
