package solution._0773.SlidingPuzzle;

import java.util.*;

public class Solution {

    private int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public int slidingPuzzle(int[][] board) {

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();

        // bfs
        int initalState = boardToInt(board);
        if (initalState == 123456){
            return 0;
        }

        visited.put(initalState, 0);
        queue.add(initalState);

        while (!queue.isEmpty()){

            Integer curs = queue.remove();

            List<Integer> nexts = getNexts(curs);

            for (int next: nexts) {
                if (!visited.containsKey(next)){
                    queue.add(next);
                    visited.put(next, visited.get(curs) + 1);

                    if (next == 123450){
                        return visited.get(next);
                    }
                }
            }
        }

        return -1;
    }

    private List<Integer> getNexts(Integer value) {

        List<Integer> res = new ArrayList<>();

        int[][] curBoard = intToBoard(value);

        int zero;
        for (zero = 0; zero < 6; zero++) {
            if (curBoard[zero / 3][zero % 3] == 0){
                break;
            }
        }
        int x = zero / 3, y = zero % 3;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (inArea(nextX, nextY)){
                swap(curBoard, x, y, nextX, nextY);
                res.add(boardToInt(curBoard));
                swap(curBoard, x, y, nextX, nextY);
            }
        }
        return res;
    }

    private int boardToInt(int[][] board){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        return Integer.parseInt(sb.toString());
    }

    private int[][] intToBoard(int value){
        int[][] board = new int[2][3];
        for (int i = 5; i >= 0; i--) {

            int r = i / 3;
            int c = i % 3;

            board[r][c] = value % 10;
            value /= 10;
        }

        return board;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < 2 && y >= 0 && y < 3;
    }

    private void swap(int[][] board, int x1, int y1, int x2, int y2){
        int t = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = t;
    }

    public static void main(String[] args) {

        int[][] board = new int[][]{{1,2,3},{4,5,0}};
        System.out.println(new Solution().slidingPuzzle(board));

    }


}
