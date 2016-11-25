package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
Given a binary tree, return the vertical order traversal of its nodes' values. 
(ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

    Given binary tree [3,9,20,null,null,15,7],

       3
      /\
     /  \
     9  20
        /\
       /  \
      15   7

    return its vertical order traversal as:

    [
      [9],
      [3,15],
      [20],
      [7]
    ]

    Given binary tree [3,9,8,4,0,1,7],

         3
        /\
       /  \
       9   8
      /\  /\
     /  \/  \
     4  01   7

    return its vertical order traversal as:

    [
      [4],
      [9],
      [3,0,1],
      [8],
      [7]
    ]

    Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),

         3
        /\
       /  \
       9   8
      /\  /\
     /  \/  \
     4  01   7
        /\
       /  \
       5   2

    return its vertical order traversal as:

    [
      [4],
      [9,5],
      [3,0,1],
      [8,2],
      [7]
    ]


 */
public class BinaryTreeVerticalOrderTraversal {
	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(root == null) return res;
    	Queue<TreeNode> nodes = new LinkedList<TreeNode>();
    	Queue<Integer> vert = new LinkedList<Integer>();
    	nodes.add(root);
    	vert.add(0);
    	while(!nodes.isEmpty()) {
    		TreeNode parent = nodes.poll();
    		int v = vert.poll();
    		if(map.containsKey(v)) {
    			map.get(v).add(parent.val);
    		} else {
    			List<Integer> list = new ArrayList<Integer>();
    			list.add(parent.val);
    			map.put(v, list);
    		}
    		max = Math.max(max, v);
    		min = Math.min(min, v);
    		if(parent.left != null) {
    			nodes.add(parent.left);
    			vert.add(v - 1);
    		}
    		if(parent.right != null) {
    			nodes.add(parent.right);
    			vert.add(v + 1);
    		}
    	}
    	for(int i = min; i <= max; i++) {
    		res.add(map.get(i));
    	}
    	return res;
    }
    
    
    public static void main(String[] args) {
    	TreeNode a = new TreeNode(3);
    	TreeNode b = new TreeNode(9);
    	TreeNode c = new TreeNode(8);
    	TreeNode d = new TreeNode(4);
    	TreeNode e = new TreeNode(0);
    	TreeNode f = new TreeNode(1);
    	TreeNode g = new TreeNode(7);
    	TreeNode h = new TreeNode(5);
    	TreeNode i = new TreeNode(2);
    	
    	a.left = b; a.right = c; b.left = d;b.right = e;c.left = f;c.right = g;e.right = i;f.left = h;
    	BinaryTreeVerticalOrderTraversal x = new BinaryTreeVerticalOrderTraversal();
    	System.out.println(x.verticalOrder(a));
    }
}
