package solution._1011.CapacityToShipPackagesWithinDDays;

import java.util.Arrays;

public class Solution {

    public int shipWithinDays(int[] weights, int days) {
        int l = max(weights), r = 25_000_000;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (shipTime(weights, mid) <= days){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int shipTime(int[] weights, int k){
        int cur = 0, res = 0;
        for(int weight: weights)
            if(cur + weight <= k) cur += weight;
            else{
                res ++;
                cur = weight;
            }
        res ++;
        return res;
    }

    public int max(int[] arr){
        int max = arr[0];
        if (arr.length > 1){
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max){
                    max = arr[i];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(
                new Solution().shipWithinDays(weights, days)
        );
    }

}
