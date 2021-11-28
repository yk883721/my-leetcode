package solution._1.Offer._0040.ZuiXiaoDeKGeShuLcof;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] arr = {0,1,1,2,4,4,1,3,3,2};
        int k = 6;
        Arrays.stream(new Solution().getLeastNumbers(arr, k)).forEach(v -> System.out.print(v + ", "));

    }

    //region 最大堆 维护最小的 k 个数字解法
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0){
            return new int[0];
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
            siftUp(ret, i);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < ret[0]){
                ret[0] = arr[i];
                siftDown(ret, 0);
            }
        }

        return ret;
    }

    public void siftUp(int[] arr, int k){
        while (k > 0 && arr[(k-1) / 2] < arr[k]){
            swap(arr, (k-1) / 2, k);
            k = (k - 1) / 2;
        }
    }

    public void siftDown(int[] arr, int k){
        while ((k * 2 + 1) < arr.length){
            int j = k * 2 + 1;
            if ((j + 1) < arr.length && arr[j + 1] > arr[j]){
                j++;
            }
            if (arr[k] >= arr[j]){
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //endregion

    //region 二分查找法
    //    public int[] getLeastNumbers(int[] arr, int k) {
//        if (k == 0){
//            return new int[0];
//        }
//        Random random = new Random();
//        int[] nums = new int[k];
//        return numsLessThenK(arr, 0, arr.length - 1, k - 1, random, nums);
//    }
//
//    public int[] numsLessThenK(int[] arr, int l, int r, int k, Random random, int[] nums){
//
//        int p = partition(arr, l, r, random);
//        if (p == k){
//            for (int i = 0; i <= k; i++) {
//                nums[i] = arr[i];
//            }
//            return nums;
//        }
//        if (p < k){
//            return numsLessThenK(arr, p + 1, r, k, random, nums);
//        }else {
//            return numsLessThenK(arr, l, p - 1, k, random, nums);
//        }
//    }
//
//    private int partition(int[] arr, int l, int r, Random random){
//        int p = random.nextInt(r + 1 - l) + l;
//        swap(arr, l, p);
//
//        int i = l + 1, j = r;
//        while (true){
//            while (i <= j && arr[i] <  arr[l])
//                i++;
//            while (i <= j && arr[j] >  arr[l])
//                j--;
//            if(i >= j)
//                break;
//
//            swap(arr, i, j);
//            i++;
//            j--;
//        }
//
//        swap(arr, l, j);
//
//        return j;
//    }
//
//    private void swap(int[] arr, int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
    //endregion

}
