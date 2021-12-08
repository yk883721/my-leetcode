package solution._0075.SortColors;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{2,0,2,1,1,0};

        sortColors2(nums);

        Arrays.stream(nums).forEach(v -> System.out.print(v + ", "));

    }

    //region 解法一 单指针，两次遍历
    public static void sortColors1(int[] nums) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                swap(nums, l, i);
                l++;
            }
        }
        // arr[0, l - 1] = 0 , arr[l ,r]  未确认
        for (int i = l; i < nums.length; i++) {
            if (nums[i] == 1){
                swap(nums, l, i);
                l++;
            }
        }
    }
    //endregion

    //region 解法二 双指针，一次遍历
//    public static void sortColors2(int[] nums) {
//        // nums[0, p1] = 0
//        // nums[p1 + 1, p2] = 1
//        // nums[p2 + 1, i - 1] = 2
//        int p1 = -1, p2 = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0){
//                p1++;
//                swap(nums, p1, i);
//                p2++;
//                if (p1 < p2){
//                    swap(nums, p2, i);
//                }
//            }else if (nums[i] == 1){
//                p2++;
//                swap(nums, p2, i);
//            }
//        }
//    }
    //endregion

    //region 解法三：排序：快排思路解法， partition
    public static void sortColors(int[] nums) {
        sort(nums, 0, nums.length -1);
    }
    private static void sort(int[] nums, int l, int r){

        if (l >= r){
            return ;
        }

        // arr[l + 1, lt] < v
        // arr[lt + 1, i - 1] = v
        // arr[gt, r] > v
        int i = l + 1, lt = l, gt = r + 1;
        while (i < gt){
            if (nums[i] < nums[l]){
                lt ++;
                swap(nums, lt, i);
                i++;
            }else if (nums[i] == nums[l]){
                i++;
            }else if (nums[i] > nums[l]){
                gt--;
                swap(nums, i, gt);
            }
        }

        // 交换后，
        // arr[l, lt-1] < v
        // arr[lt, gt-1] = v
        // arr[gt, r] > v
        swap(nums, l, lt);

        sort(nums, l, lt - 1);
        sort(nums, gt,  r);

    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //endregion

    // region 计数排序解法
    public static void sortColors2(int[] nums) {
        int R = 2;
        int n = nums.length;
        int[] cnt = new int[R];
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }

        int[] index = new int[R + 1];
        for (int i = 0; i < cnt.length; i++) {
            // index[i]...index[i+1] = i
            index[i + 1] = index[i] + cnt[i];
        }

        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[index[nums[i]]] = nums[i];
            index[nums[i]]++;
        }
        System.arraycopy(ret,0 , nums, 0, n);
    }
    // endregion


}
