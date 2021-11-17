package solution._0215.kthLargestElementInAnArray;

import java.util.Random;

public class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        //0 1 2 3 4 5
        //6 5 4 3 2 1
        // 第 k 大的元素，先快排后，转化为寻找下标为 (nums.length - k) 的元素
        return selectK(nums, 0, nums.length - 1, nums.length - k, random);
    }

    private static int selectK(int[] arr, int l, int r, int k, Random random){
        int p = partition(arr, l, r, random);
        if (p == k){
            return arr[p];
        }
        if (k < p){
            return selectK(arr, l, p-1, k, random);
        }else {
            return selectK(arr, p+1, r, k, random);
        }
    }

    private static int partition(int[] arr, int l, int r, Random random){
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        int i = l + 1, j = r;
        while (true){
            while (i <= j && arr[i] < arr[l]){
                i++;
            }
            while (i <= j && arr[j] > arr[l]){
                j--;
            }
            if (i >= j){
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
