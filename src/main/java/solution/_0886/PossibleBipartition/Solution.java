package solution._0886.PossibleBipartition;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    private HashSet<Integer>[] G;
    private HashMap<Integer, Integer> colors;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        G = new HashSet[n];
        for (int i = 0; i < n; i++) {
            G[i] = new HashSet<>();
        }
        for (int[] dislike : dislikes) {
            G[dislike[0] - 1].add(dislike[1] - 1);
            G[dislike[1] - 1].add(dislike[0] - 1);
        }
        colors = new HashMap<>();

        for (int v = 0; v < n; v++) {
            if (!colors.containsKey(v) && !dfs(v, 0)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int v, int color){
        colors.put(v, color);
        for (Integer w : G[v]) {
            if (!colors.containsKey(w)){
                if (!dfs(w, 1-color)){
                    return false;
                }
            }else if (color == colors.get(w)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int N = 4;
        int[][] dislikes = new int[][]{{1,2},{1,3},{2,3}};

        System.out.println(new Solution().possibleBipartition(N, dislikes));
    }
}
