package solution._0547.NumberOfProvinces;

import java.util.TreeSet;

public class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1){
                    int pId = id[i];
                    int qId = id[j];

                    if (pId != qId){
                        for (int k = 0; k < id.length; k++) {
                            if (id[k] == pId){
                                id[k] = qId;
                            }
                        }
                    }
                }
            }
        }
        
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0 ; i < n ; i ++)
            set.add(id[i]);
        return set.size();
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(new Solution().findCircleNum(nums));
    }



}
