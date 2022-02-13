package solution._0980.UniquePathsIII;

public class Solution {

    private int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    private int[][] grid;
    private boolean[][] visited;
    private int R, C;

    private int start, end;
    private int sum = 0;

    public int uniquePathsIII(int[][] grid) {

        this.grid = grid;
        this.R = grid.length;
        this.C = grid[0].length;
        this.visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1){
                    start = i * C + j;
                    grid[i][j] = 0;
                    sum++;
                }else if (grid[i][j] == 2){
                    this.end = i * C + j;
                    grid[i][j] = 0;
                    sum++;
                }else if(grid[i][j] == 0){
                    sum++;
                }
            }
        }

        return dfs(start, 0);

    }

    private int dfs(int v, int visitedNum){
        int x = v / C;
        int y = v % C;
        visited[x][y] = true;
        visitedNum++;

        if (v == end && visitedNum == sum){
            visited[x][y] = false;
            return 1;
        }

        int res = 0;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (inArea(nextX, nextY) && grid[nextX][nextY] == 0 && !visited[nextX][nextY]){
                int w = nextX * C + nextY;
                res += dfs(w, visitedNum);
            }
        }

        visited[x][y] = false;
        return res;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{{0,0},{2,1}};
        System.out.println(new Solution().uniquePathsIII(grid));

    }


}
