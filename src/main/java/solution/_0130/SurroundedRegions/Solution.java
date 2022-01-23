package solution._0130.SurroundedRegions;

import java.util.*;

public class Solution {

    private int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    private char[][] board;
    private boolean[][] visited;

    private int R;
    private int C;

    private Map<Integer, List<Integer>> ccs;
    private List<Integer> inNonEdgeIds;

    public void solve(char[][] board) {

        this.board = board;
        this.R = board.length;
        this.C = board[0].length;
        this.visited = new boolean[R][C];

        ccs = new HashMap<>();
        inNonEdgeIds = new ArrayList<>();

        int ccid = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && board[i][j] == 'O'){
                    bfs(i, j, ccid);
                    ccid++;
                }
            }
        }

        for (Integer nonEdgeId : inNonEdgeIds) {
            List<Integer> vList = ccs.get(nonEdgeId);
            for (Integer v : vList) {
                int x = v / C;
                int y = v % C;
                board[x][y] = 'X';
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int x, int y, int ccid){
        boolean hasEdge = false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x * C + y);
        visited[x][y] = true;
        if (inEdge(x,y)){
            hasEdge = true;
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(x * C + y);
        ccs.put(ccid, list);

        while (!queue.isEmpty()){
            Integer v = queue.remove();
            int r = v / C;
            int c = v % C;

            for (int[] dir : dirs) {
                int nextX = r + dir[0];
                int nextY = c + dir[1];

                if (inArea(nextX, nextY) && board[nextX][nextY] == 'O' && !visited[nextX][nextY]){
                    queue.add(nextX * C + nextY);

                    visited[nextX][nextY] = true;
                    ccs.get(ccid).add(nextX * C + nextY);

                    if (inEdge(nextX, nextY)){
                        hasEdge = true;
                    }
                }
            }
        }

        if (!hasEdge){
            inNonEdgeIds.add(ccid);
        }

    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    private boolean inEdge(int x, int y){
        return x == 0 || x == R - 1 || y == 0 || y == C - 1;
    }

    public static void main(String[] args) {

        char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        Solution solution = new Solution();
        solution.solve(board);

    }


}
