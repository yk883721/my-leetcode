package solution._0704.BinarySearch;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{-1,0,3,5,9,12},111));
    }

    public int search(int[] nums, int target) {
        // 解法二，直接非递归实现二分查找
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid -1;
            }
        }
        return -1;
    }

    // 解法一，递归实现二分查找
    private int search(int[] nums, int l, int r, int target){
        if (l > r){
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return search(nums, mid + 1, r, target);
        }else
            return search(nums, l, mid - 1, target);
    }

}
