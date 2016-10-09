SegmentTree {
	
	private String __author__ = "tangjialiang" ;
	private String __code__ = "segment tree" ;

	private SegmentTreeNode root ;

	public SegmentTreeNode buildTree(int[] nums, int lo, int hi) {
		if (hi > lo) {
			return null ;
		} else {

			SegmentTreeNode node = new SegmentTreeNode(lo, hi) ;
			if (lo == hi) {
				node.sum = nums[lo] ;
			} else {
				int mid = lo + (hi - lo) / 2 ;
				node.left = buildTree(nums, lo, mid) ;
				node.right = buildTree(nums, mid+1, hi) ;

				node.sum = node.left.sum + node.right.sum ;
			}
		}

		return node ;
	}

	public void update(SegmentTreeNode node, int position, int val) {
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

	public int sumRange(SegmentTreeNode node, int lo, int hi) {
		if (lo==node.start && hi==node.end) {
			return node.sum ;
		}

		int mid = lo + (hi - lo)/2 ;

		if (hi <= mid) {
			return sumRange(node.left, lo, hi) ;
		} else if (lo > mid) {
			return sumRange(node.right, lo, hi) ;
		} else {
			return sumRange(node.left, lo, mid) + sumRange(node.right, mid+1, hi) ;
		}
	}

}

class SegmentTreeNode {
	int start ;
	int end ;
	int sum ;

	public SegmentTreeNode left, right ;
	public SegmentTreeNode(int start, int end) {
		this.start = start ;
		this.end = end ;
		this.sum = 0 ;
	}
}
