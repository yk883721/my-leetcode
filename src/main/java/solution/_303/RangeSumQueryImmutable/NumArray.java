package solution._303.RangeSumQueryImmutable;

public class NumArray {


    //region 解法一：预处理一个前 i 个元素的和的数组
    //sum[i] 存储的是前 i 个元素的和
    //sum[0] = 0;
    //nums[2...5],  sum[6] 0 1 2 3 4 5, sum[2] 0 1
    private final int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
    //endregion

    //region 解法二：segmentTree 线段 区间树解法
//    private final int[] tree;
//    private final int[] data;
//    public NumArray(int[] nums) {
//        data = new int[nums.length];
//        System.arraycopy(nums, 0, data, 0, nums.length);
//        tree = new int[nums.length * 4];
//        buildTree(0,0,data.length - 1);
//    }
//
//    public int sumRange(int left, int right) {
//        return sumRange(0, 0, data.length - 1, left, right);
//    }
//
//    private void buildTree(int treeIndex, int l, int r){
//        if (l >= r){
//            tree[treeIndex] = data[l];
//            return;
//        }
//
//        int mid = l + (r - l) / 2;
//        int leftChild = leftChild(treeIndex);
//        int rightChild = rightChild(treeIndex);
//
//        buildTree(leftChild, l, mid);
//        buildTree(rightChild, mid + 1, r);
//
//        tree[treeIndex] = tree[leftChild] + tree[rightChild];
//
//    }
//
//    private int leftChild(int index){
//        return 2 * index + 1;
//    }
//
//    private int rightChild(int index){
//        return 2 * index + 2;
//    }
//
//    private int sumRange(int treeIndex,int l, int r, int queryL, int queryR) {
//        if (l == queryL && r == queryR){
//            return tree[treeIndex];
//        }
//
//        int mid = l + (r - l) / 2;
//        int leftChild = leftChild(treeIndex);
//        int rightChild = rightChild(treeIndex);
//
//        if (queryL >= (mid + 1)){
//            return sumRange(rightChild, mid + 1, r, queryL, queryR);
//        }else if (queryR <= mid){
//            return sumRange(leftChild, l , mid, queryL, queryR);
//        }
//
//        int leftResult = sumRange(leftChild, l, mid, queryL, mid);
//        int rightResult = sumRange(rightChild, mid + 1, r, mid + 1, queryR);
//
//        return leftResult + rightResult;
//
//    }
    //endregion

    public static void main(String[] args) {

        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));

    }

}
