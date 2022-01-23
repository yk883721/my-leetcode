package solution._1034.ColoringABorder;

public class Solution {

    private int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    private int[][] grid;
    private boolean[][] visited;

    private int R;
    private int C;

    private int newColor;
    private int oldColor;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {

        this.grid = grid;
        this.R = grid.length;
        this.C = grid[0].length;
        this.visited = new boolean[R][C];

        this.newColor = color;
        this.oldColor = grid[row][col];

        if (oldColor == newColor){
            return grid;
        }
        dfs(row, col);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        return grid;
    }

    private void dfs(int x, int y){
        visited[x][y] = true;
        if (inEdge(x, y)){
            grid[x][y] = newColor;
        }

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (inArea(nextX,nextY) && !visited[nextX][nextY]){
                if (grid[nextX][nextY] == oldColor){
                    dfs(nextX,nextY);
                }else{
                    grid[x][y] = newColor;
                }
            }
        }
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    private boolean inEdge(int x, int y){
        return x == 0 || x == R - 1 || y == 0 || y == C - 1;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{{1,1,1},{1,1,1},{1,1,1}};
        new Solution().colorBorder(grid,1,1,2);

    }


}
