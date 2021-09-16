package solution._1.Offer._0051.ReversePairsNum;

public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().reversePairs(new int[]{2,4,6,8,1,3,5}));

    }

    public int reversePairs(int[] nums) {

        int[] temp = new int[nums.length];
        int sum = mergeSortBU(nums, temp);
        return sum;

    }

    // 一、归并 - 递归解法
    private int mergeSort(int[] nums, int l, int r, int[] temp){
        if (l >= r){
            return 0;
        }

       int mid = l + ( r - l ) / 2;

        int left = mergeSort(nums, l, mid, temp);
        int right = mergeSort(nums, mid + 1, r, temp);
        int center = merge(nums, l, mid, r, temp);

        return left + right + center;
    }

    // 二、归并解法 - 自底向上
    private int mergeSortBU(int[] nums, int[] temp){

        int n = nums.length;
        int res = 0;
        for (int sz = 1; sz < n; sz += sz){

            int l = 0;

            for (l = 0; l + sz < n ;l = l + 2 * sz){

                int mid = l + sz - 1;
                int r = Math.min(l + 2 * sz - 1, n - 1) ;
                int number = merge(nums, l, mid, r, temp);
                res += number;

            }

        }

        return res;
    }

    private int merge(int[] nums, int l, int mid, int r, int[] temp){
        for (int i = l; i <= r; i++){
            temp[i] = nums[i];
        }

        int res = 0;
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++){
            if (i > mid){
                nums[k] = temp[j];
                j++;
            }else if (j > r){
                nums[k] = temp[i];
                i++;

            }else if (temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;

            }else {
                int value = (mid - i + 1);
                res += value;

                nums[k] = temp[j];
                j++;
            }
        }

        return res;
    }
}
