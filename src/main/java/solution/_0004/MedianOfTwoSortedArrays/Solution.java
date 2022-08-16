package solution._0004.MedianOfTwoSortedArrays;

public class Solution {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};

        double median = new Solution().findMedianSortedArrays(nums1, nums2);

        System.out.println(median);

    }

    public double findMedianSortedArraysTwo(int[] nums1, int[] nums2) {
        
    }


    // 暴力先合并数组
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] nums = new int[n1 + n2];
        int i = 0, j = 0, n = 0;
        while (i < n1 && j < n2) {
            int v1 = nums1[i];
            int v2 = nums2[j];

            if (v1 < v2) {
                nums[n++] = v1;
                i++;
            }else {
                nums[n++] = v2;
                j++;
            }
        }
        while (i < n1) {
            nums[n++] = nums1[i++];
        }
        while (j < n2) {
            nums[n++] = nums2[j++];
        }

        int length = nums.length;
        if (length % 2 == 0) {
            return (nums[length / 2] + nums[(length - 1) / 2 ]) / 2.0;
        }else {
            return nums[length / 2];
        }
    }


}
