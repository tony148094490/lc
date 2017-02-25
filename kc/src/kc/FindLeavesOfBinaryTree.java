package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLeavesOfBinaryTree {
    
    Map<Integer, List<Integer>> map = new HashMap<>();;
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        int max = iteration(root);
        for(int i = 1; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
    
    private int iteration(TreeNode root) {
        if(root.left == null && root.right == null) {
            List<Integer> list = map.get(1);
            if(list == null) list = new ArrayList<Integer>();
            list.add(root.val);
            map.put(1, list);
            return 1;
        } else {
            int left = root.left == null ? 0 : iteration(root.left);
            int right = root.right == null ? 0 : iteration(root.right);
            int res = Math.max(left, right) + 1;
            List<Integer> list = map.get(res);
            if(list == null) list = new ArrayList<Integer>();
            list.add(root.val);
            map.put(res, list);
            return res;
        }
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		a.left = b;a.right=c;b.left=d;b.right=e;
		FindLeavesOfBinaryTree x = new FindLeavesOfBinaryTree();
		System.out.println(x.findLeaves(a));
	}
}
