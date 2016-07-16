package kc;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) 	{
    	if(n==0) return new ArrayList<TreeNode>();
    	return generate(1,n);
    }
    
    
    private List<TreeNode> generate(int l, int r) {
    	
    	if(l > r) {
    		List<TreeNode> res = new ArrayList<TreeNode>();
    		res.add(null);
    		return res;
    	}
    	
    	if(l == r) {
    		TreeNode res = new TreeNode(l);
    		List<TreeNode> list = new ArrayList<TreeNode>();
    		list.add(res);
    		return list;
    	}
        
		List<TreeNode> res = new ArrayList<TreeNode>();
        for(int i = l ; i<= r; i++){
        	List<TreeNode> left = generate(l,i-1);
        	List<TreeNode> right = generate(i+1,r);
        	
	        for(TreeNode ll : left) {
	        	for(TreeNode rr : right) {
	        		TreeNode mid = new TreeNode(i);
	        		mid.left = ll;
	        		mid.right = rr;
	        		res.add(mid);
	        	}
	        }
        }
    	
        return res;
    }
    
    public static void main(String[] args) {
    	UniqueBinarySearchTreeII x = new UniqueBinarySearchTreeII();
    	List<TreeNode> res = x.generateTrees(3);
    	for(TreeNode xx : res) {
    		System.out.println(xx.val);
    	}
	}
}
