package kc;

public class NumArray {
	
	SegmentTreeNode root = null;
	
    public NumArray(int[] nums) {
    	
    	root = buildTree(nums, 0, nums.length-1);
    }
    
    private SegmentTreeNode buildTree(int[] nums, int l, int r) {
    	if(l > r) return null;
		SegmentTreeNode res = new SegmentTreeNode();
    	if(l == r) {
    		res.start = l;
    		res.end = r;
    		res.val = nums[l];
    		return res;
    	}
    	
    	int m = l + (r - l) / 2;
    	SegmentTreeNode leftSum = buildTree(nums,l,m);
    	SegmentTreeNode rightSum = buildTree(nums, m+1,r);
    	res.val = leftSum.val + rightSum.val;
    	res.start = l;
    	res.end = r;
    	res.left = leftSum;
    	res.right = rightSum;
    	return res;
    }

    void update(int i, int val) {
    	updateHelper(i, val, root);
    }
    
    private int updateHelper(int i, int val, SegmentTreeNode root) {
    	if(root == null) return 0;
    	if(root.start == i && root.end == i) {
    		root.val = val;
    		return val;
    	}
    	if(root.start > i || root.end < i) return root.val;
    	int left = updateHelper(i, val, root.left);
    	int right = updateHelper(i, val, root.right);
    	root.val = left + right;
    	return root.val;
    }

    public int sumRange(int i, int j) {
    	return helper(i,j,this.root);
    }
    private int helper(int i, int j, SegmentTreeNode root) {
    	if(root == null) return 0;
    	if(root.start == i && root.end == j) {
    		return root.val;
    	}
    	
    	if(j < root.start || i > root.end) return 0;
    	int left = 0;
    	if(root.left != null && i >= root.start && j <= root.left.end) {
    		left = helper(i, j, root.left);
    	} else if(root.left != null && i >= root.start) {
    		left = helper(i, root.left.end, root.left);
    	}
    	
    	int right = 0;
    	if(root.right != null && i >= root.right.start && j <= root.end) {
    		right = helper(i, j, root.right);
    	} else if(root.right != null && j <= root.end) {
    		right = helper(root.right.start, j, root.right);
    	}
    	
    	return left + right;
    }

    public class SegmentTreeNode {
    	int start;
    	int end;
    	int val;
    	SegmentTreeNode left = null;
    	SegmentTreeNode right = null;
    }
    
    
    public static void main(String[] args) {
    	  int[] nums = {0,9,5,7,3};
    	  NumArray numArray = new NumArray(nums);
    	  System.out.println( numArray.sumRange(0, 4));
	}

}
