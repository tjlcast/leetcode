public class NumArray {
    
    public String __author__ = "tangjialiang" ;
    public String __V__ = "success_V" ;
    public String __tips__ = "线段树" ;
    
    private class SegmentTreeNode {
        public int start;
        public int end;
        public int sum;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }
    }
    
    private SegmentTreeNode root;
    
    private SegmentTreeNode buildTree(int[] nums, int lo, int hi) {
        if(lo > hi) {
            return null;
        } else {
            SegmentTreeNode node = new SegmentTreeNode(lo, hi);
            if(lo == hi) {
                node.sum = nums[lo];
            } else {
                int mid = lo + (hi - lo) / 2;
                node.left = buildTree(nums, lo, mid);
                node.right = buildTree(nums, mid + 1, hi);
                node.sum = node.left.sum + node.right.sum;
            }
            return node;
        }
    }
    
    private int sumRange(SegmentTreeNode node, int lo, int hi) {
        if(node.start == lo && node.end == hi) {
            return node.sum;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if(hi <= mid) {
            return sumRange(node.left, lo, hi);
        } else if (lo > mid) {
            return sumRange(node.right, lo, hi);
        } else {
            return sumRange(node.left, lo, mid) + sumRange(node.right, mid + 1, hi);
        }
    }
    
    private void update(SegmentTreeNode node, int position, int val) {
        if(node.start == position && node.end == position) {
            node.sum = val;
            return;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if(position <= mid) {
            update(node.left, position, val);
        } else {
            update(node.right, position, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    public NumArray(int[] nums) {
        this.root = buildTree(nums, 0, nums.length - 1);  
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
