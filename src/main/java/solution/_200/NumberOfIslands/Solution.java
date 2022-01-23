package solution._200.NumberOfIslands;

public class Solution {

    private int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    private char[][] grid;
    private boolean[][] visited;
    private int R;
    private int C;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.R = grid.length;
        this.C = grid[0].length;

        this.visited = new boolean[R][C];
        int res = 0;

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (!visited[x][y] && grid[x][y] == '1'){
                    dfs(x,y);
                    res++;
                }
            }
        }

        return res;
    }

    private int dfs(int x, int y){
        visited[x][y] = true;

        int res = 1;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (inArea(nextX, nextY) && grid[nextX][nextY] == '1' && !visited[nextX][nextY]){
                res += dfs(nextX, nextY);
            }
        }
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {

        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(new Solution().numIslands(grid));

    }

}
