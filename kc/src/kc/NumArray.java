package kc;

public class NumArray {
    TreeNode root = null;

    public NumArray(int[] nums) {
        root = init(nums, 0, nums.length-1);
    }
    
    public void update(int i, int val) {
        updateHelper(i, val, root);
    }
    
    public int sumRange(int i, int j) {
        return sumRangeHelper(i,j,root);
    }
    
    private TreeNode init(int[] arr, int start, int end) {
        if(start > end) return null;
        TreeNode node = new TreeNode();
        if(start == end) {
            node.start = start;
            node.end = end;
            node.val = arr[start];
            return node;
        }
        int mid = start + (end - start) / 2;
        TreeNode leftChild = init(arr, start, mid);
        TreeNode rightChild = init(arr, mid+1, end);
        TreeNode res = new TreeNode();
        res.start = start;
        res.end = end;
        res.val = leftChild.val + rightChild.val;
        res.left = leftChild;
        res.right = rightChild;
        return res;
    }
    
    private int updateHelper(int i, int val, TreeNode root) {
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
    
    private int sumRangeHelper(int i, int j, TreeNode node) {
        int res = 0;
        if(node == null) return 0;
        if(node.start == i && node.end == j) return node.val;
        if(i > j) return 0;
        if(node.start > j || node.end < i) return 0;
        if(node.left != null) res += sumRangeHelper(i, Math.min(j,node.left.end), node.left);
        if(node.right !=null) res += sumRangeHelper(Math.max(node.right.start,i), j, node.right);
        return res;
    }
    
    
    class TreeNode {
        int start, end, val;
        TreeNode left = null;
        TreeNode right = null;
        
        @Override
        public String toString() {
        	return "Start:" + start + ", End:" + end + ", Val:" + val;
        }
    }
    
    
    public static void main(String[] args) {
    	  int[] nums = {0,9,5,7,3};
    	  NumArray numArray = new NumArray(nums);
    	  System.out.println(numArray.root.left);
    	  System.out.println( numArray.sumRange(3, 3));
	}

}
