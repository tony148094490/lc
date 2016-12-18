package kc;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) 	{
        if(n == 0) return new ArrayList<TreeNode>();
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int left, int right) {

        if(left == right) {
            List<TreeNode> trees = new ArrayList<TreeNode>();
            TreeNode node = new TreeNode(left);
            trees.add(node);
            return trees;
        }
        
        List<TreeNode> trees = new ArrayList<TreeNode>();
        for(int i = left; i <= right; i++) {
            List<TreeNode> leftChildren = new ArrayList<TreeNode>();
            List<TreeNode> rightChildren = new ArrayList<TreeNode>();
            
            if(i == left) {
                leftChildren.add(null);
            } else {
                leftChildren = helper(left, i-1);
            }
            
            if( i == right) {
                rightChildren.add(null);
            } else {
                rightChildren = helper(i+1, right);
            }
            

            for(TreeNode leftChild : leftChildren) {
                for(TreeNode rightChild : rightChildren) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftChild;
                    root.right = rightChild;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
    
    public static void main(String[] args) {
    	UniqueBinarySearchTreeII x = new UniqueBinarySearchTreeII();
    	List<TreeNode> res = x.generateTrees(3);
    	for(TreeNode xx : res) {
    		System.out.println(xx.val);
    	}
	}
}
