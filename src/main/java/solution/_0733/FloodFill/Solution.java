package solution._0733.FloodFill;

public class Solution {

    private int[][] dirs = new int[][]{{-1, 0},{0,1},{1,0},{0,-1}};

    private int[][] image;
    private boolean[][] visited;
    private int R;
    private int C;

    private int oldColor;
    private int newColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        this.image = image;
        this.R = image.length;
        this.C = image[0].length;
        this.visited = new boolean[R][C];

        this.oldColor = image[sr][sc];
        this.newColor = newColor;

        dfs(sr, sc);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

        return image;

    }

    public void dfs(int x, int y){

        visited[x][y] = true;
        image[x][y] = newColor;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && image[nextX][nextY] == oldColor){
                dfs(nextX, nextY);
            }
        }

    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {

        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};

        Solution solution = new Solution();
        solution.floodFill(image, 1, 1, 2);


    }

}
