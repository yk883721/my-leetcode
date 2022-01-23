package solution._0307.RangeSumQueryMutable;

import java.util.Arrays;

public class NumArray {

    //region 解法一：线段树
    //
//    private final int[] tree;
//    private final int[] data;
//
//    public NumArray(int[] nums) {
//        data = new int[nums.length];
//        System.arraycopy(nums, 0, data, 0, nums.length);
//        tree = new int[nums.length * 4];
//        buildTree(0,0,data.length - 1);
//    }
//
//    public void update(int index, int val) {
//        set(0, 0, data.length - 1, index, val);
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
//    private void set(int treeIndex, int l, int r, int index, int val){
//        if (l >= r){
//            tree[treeIndex] = val;
//            return;
//        }
//
//        int mid = l + (r - l) / 2;
//        int leftChild = leftChild(treeIndex);
//        int rightChild = rightChild(treeIndex);
//        if (index >= mid + 1){
//            set(rightChild, mid + 1, r, index, val);
//        }else {
//            set(leftChild, l, mid, index, val);
//        }
//
//        tree[treeIndex] = tree[leftChild] + tree[rightChild];
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

    //region 解法二：SQRT分解
    private final int[] data, blocks;
    private int N; //元素总数
    private int B; //每组元素个数
    private int Bn;//组数
    public NumArray(int[] nums) {
        N = nums.length;
        B = (int)Math.floor(Math.sqrt(nums.length));
        Bn = (N / B) + (N % B > 0 ? 1: 0);

        data = Arrays.copyOf(nums, N);
        blocks = new int[Bn];
        for (int i = 0; i < N; i++) {
            blocks[i / B] += nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left < 0 || right < 0
                || left > N || right > N){
            return 0;
        }
        int bStart = left / B;
        int bEnd = right / B;

        int res = 0;
        if (bStart == bEnd){
            for (int i = left; i <= right; i++) {
                res += data[i];
            }
            return res;
        }

        for (int i = left; i < ( bStart + 1) * B; i++) {
            res += data[i];
        }

        for (int i = bStart + 1; i < bEnd; i++) {
            res += blocks[i];
        }

        for (int i = bEnd * B; i <= right; i++) {
            res += data[i];
        }

        return res;
    }

    public void update(int index, int val) {
        int oldValue = data[index];

        data[index] = val;
        blocks[index / B] = blocks[index / B] - oldValue + val;
    }
    //endregion

}
