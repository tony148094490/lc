package kc;

import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> parent = new LinkedList<TreeNode>();
        parent.add(root);
        while(!parent.isEmpty()) {
            LinkedList<TreeNode> children = new LinkedList<TreeNode>();
            while(!parent.isEmpty()) {
                TreeNode p = parent.poll();
                if(p == null) {
                    sb.append("#,");
                } else {
                    sb.append(p.val + ",");
                    children.add(p.left);
                    children.add(p.right);
                }
            }
            parent = children;
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int counter = 1;
        if(nodes.length < 2) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        LinkedList<TreeNode> parents = new LinkedList<TreeNode>();
        parents.add(root);
        while(!parents.isEmpty()) {
            LinkedList<TreeNode> children = new LinkedList<TreeNode>();
            while(!parents.isEmpty()) {
                TreeNode parent = parents.poll();
                String str = nodes[counter];
                // get left
                if(!str.equals("#")) {
                    TreeNode left = new TreeNode(Integer.parseInt(str));
                    parent.left = left;
                    children.add(left);
                }
                counter++;
                // get right
                str = nodes[counter];
                if(!str.equals("#")) {
                    TreeNode right = new TreeNode(Integer.parseInt(str));
                    parent.right = right;
                    children.add(right);
                }
                counter++;
            }
            parents = children;
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
