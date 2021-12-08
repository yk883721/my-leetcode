package solution._307.RangeSumQueryMutable;

public class NumArray {

    private final int[] tree;
    private final int[] data;

    public NumArray(int[] nums) {
        data = new int[nums.length];
        System.arraycopy(nums, 0, data, 0, nums.length);
        tree = new int[nums.length * 4];
        buildTree(0,0,data.length - 1);
    }

    public void update(int index, int val) {
        set(0, 0, data.length - 1, index, val);
    }

    public int sumRange(int left, int right) {
        return sumRange(0, 0, data.length - 1, left, right);
    }

    private void buildTree(int treeIndex, int l, int r){
        if (l >= r){
            tree[treeIndex] = data[l];
            return;
        }

        int mid = l + (r - l) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        buildTree(leftChild, l, mid);
        buildTree(rightChild, mid + 1, r);

        tree[treeIndex] = tree[leftChild] + tree[rightChild];

    }

    private void set(int treeIndex, int l, int r, int index, int val){
        if (l >= r){
            tree[treeIndex] = val;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        if (index >= mid + 1){
            set(rightChild, mid + 1, r, index, val);
        }else {
            set(leftChild, l, mid, index, val);
        }

        tree[treeIndex] = tree[leftChild] + tree[rightChild];
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    private int sumRange(int treeIndex,int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR){
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        if (queryL >= (mid + 1)){
            return sumRange(rightChild, mid + 1, r, queryL, queryR);
        }else if (queryR <= mid){
            return sumRange(leftChild, l , mid, queryL, queryR);
        }

        int leftResult = sumRange(leftChild, l, mid, queryL, mid);
        int rightResult = sumRange(rightChild, mid + 1, r, mid + 1, queryR);

        return leftResult + rightResult;

    }

}
