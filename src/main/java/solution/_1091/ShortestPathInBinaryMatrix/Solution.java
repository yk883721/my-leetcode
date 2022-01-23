package solution._1091.ShortestPathInBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int[][] dirs = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

    private int[][] grid;
    private int N;

    private boolean[][] visited;
    private int[][] dist;

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.grid = grid;
        this.N = grid.length;

        if (grid[0][0] == 1 || grid[N-1][N-1] == 1){
            return -1;
        }
        if (N == 1){
            return 1;
        }

        this.visited = new boolean[N][N];
        this.dist = new int[N][N];

        return bfs();
    }

    private int bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0][0] = true;
        dist[0][0] = 1;

        while (!queue.isEmpty()){
            Integer v = queue.remove();
            int r = v / N;
            int c = v % N;

            for (int[] dir : dirs) {
                int nextX = r + dir[0];
                int nextY = c + dir[1];

                if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 0){
                    queue.add(nextX * N + nextY);

                    visited[nextX][nextY] = true;
                    dist[nextX][nextY] = 1 + dist[r][c];

                    if (nextX == N - 1 && nextY == N - 1){
                        return dist[nextX][nextY];
                    }
                }
            }
        }

        return -1;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{{0}};
        System.out.println(new Solution().shortestPathBinaryMatrix(grid));

    }

}
