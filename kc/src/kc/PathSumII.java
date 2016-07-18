package kc;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root,sum,new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
    	if(root == null) return;
    	if(root.left == null && root.right == null && root.val == sum) {
    		cur.add(root.val);
    		res.add(new ArrayList<Integer>(cur));
    		cur.remove(cur.size()-1);
    	} else {
    		cur.add(root.val);
    		helper(root.left, sum - root.val, cur,res);
    		helper(root.right, sum - root.val,cur, res);
    		cur.remove(cur.size()-1);
    	}
    }
}
