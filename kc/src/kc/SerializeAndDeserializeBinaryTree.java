package kc;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
    	StringBuilder sb = new StringBuilder();
        Queue<TreeNode> parents = new LinkedList<TreeNode>();
        Queue<TreeNode> children = new LinkedList<TreeNode>();
        sb.append(root.val);
        sb.append(",");
        parents.add(root);
        while(!parents.isEmpty()) {
        	while(!parents.isEmpty()) {
        		TreeNode parent = parents.poll();
        		if(parent.left == null) {
        			sb.append("#");
        			sb.append(",");
        		} else {
        			sb.append(parent.left.val);
        			sb.append(",");
        			children.add(parent.left);
        		}
        	
        		if(parent.right == null) {
        			sb.append("#");
        			sb.append(",");
        		} else {
        			sb.append(parent.right.val);
        			sb.append(",");
        			children.add(parent.right);
        		}
        	}
        	parents = children;
        	children = new LinkedList<TreeNode>();
        }
        return sb.substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() <= 0) return null;
        if(data.length() == 1 && data.charAt(0) == '#') return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> parents = new LinkedList<TreeNode>();
        Queue<TreeNode> children = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        parents.add(root);
        for(int i = 1; i < nodes.length; i++) {
        	if(!parents.isEmpty()) {
        		TreeNode parent = parents.poll();
        		if(!nodes[i].equals("#")) {
        			TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
        			parent.left = left;
        			children.add(left);
        		}
        		i++;
        		if(!nodes[i].equals("#")) {
        			TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
        			parent.right = right;
        			children.add(right);
        		}
        	} else if(!children.isEmpty()){
        		parents = children;
        		children = new LinkedList<TreeNode>();
        		i--;
        	}
        }
        return root;
    }
    
    public static void main(String[] args) {
    	
    	TreeNode a = new TreeNode(1);
    	TreeNode b = new TreeNode(2);
    	TreeNode c = new TreeNode(3);
    	TreeNode d = new TreeNode(4);
    	TreeNode e = new TreeNode(5);
    	TreeNode f = new TreeNode(6);
    	TreeNode g = new TreeNode(7);
    	TreeNode n = new TreeNode(8);
    	a.left = b;a.right = c;b.left=d;b.right=e;e.left=g;c.right=f;f.right=n;
    	SerializeAndDeserializeBinaryTree x = new SerializeAndDeserializeBinaryTree();
    	System.out.println(x.deserialize(x.serialize(a)));
    	
    	
    }
}
