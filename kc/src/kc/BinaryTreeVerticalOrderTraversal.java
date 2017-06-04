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
This can only be done by top down breath first search 

 */
public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> levels = new HashMap<Integer, List<Integer>>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> parents = new LinkedList<TreeNode>();
        Queue<Integer> parentsLevels = new LinkedList<Integer>();
        parents.add(root);
        parentsLevels.add(0);
        while(!parents.isEmpty()) {
            TreeNode parent = parents.poll();
            int level = parentsLevels.poll();
            if(levels.containsKey(level)) {
                levels.get(level).add(parent.val);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(parent.val);
                levels.put(level, list);
            }
            min = Math.min(min, level);
            max = Math.max(max, level);
            if(parent.left != null) {
                parents.add(parent.left);
                parentsLevels.add(level-1);
            }
            if(parent.right != null) {
                parents.add(parent.right);
                parentsLevels.add(level+1);
            }
        }
        for(int i = min ; i <= max; i++) {
            res.add(levels.get(i));
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
