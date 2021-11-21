package solution._0875.KokoEatingBananas;

public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,7,11};
        int H = 8;
        System.out.println(new Solution().minEatingSpeed(arr, H));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = max(piles);
        while (l < r){
            int mid = l + (r - l) / 2;
            if (eatingTime(piles, mid) <= h){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    public long eatingTime(int[] piles, int n){
        long res = 0;
        for (int pile : piles) {
            res += pile / n + (pile % n > 0 ? 1 : 0 );
        }
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


}
