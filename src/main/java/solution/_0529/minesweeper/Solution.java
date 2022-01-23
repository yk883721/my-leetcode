package solution._0529.minesweeper;

public class Solution {

    private int[][] dirs = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    private char[][] board;

    private int R;
    private int C;

    public char[][] updateBoard(char[][] board, int[] click) {
        this.board = board;
        this.R = board.length;
        this.C = board[0].length;

        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M'){
            board[x][y] = 'X';
        }else {
            dfs(x,y);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        return board;
    }

    private void dfs(int x, int y){
        int cnt = 0;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (inArea(nextX, nextY) && board[nextX][nextY] == 'M'){
                cnt++;
            }
        }
        if (cnt > 0){
            // 规则 3
            board[x][y] = (char) (cnt + '0');
        }else {
            // 规则2
            board[x][y] = 'B';
            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (inArea(nextX, nextY) && board[nextX][nextY] == 'E') {
                    dfs(nextX, nextY);
                }
            }
        }
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        int[] click = new int[]{3,0};

        new Solution().updateBoard(board, click);
    }

}
