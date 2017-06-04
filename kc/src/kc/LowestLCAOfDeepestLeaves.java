package kc;

import java.util.ArrayList;
import java.util.List;

public class LowestLCAOfDeepestLeaves {
	public TreeNode findLCA(TreeNode root) {
		return helper(root).node;
	}
	
	private Wrapper helper(TreeNode root) {
		if(root == null) 
			return new Wrapper(null, 0);

		List<Wrapper> children = new ArrayList<>();
		for(TreeNode c : root.children) {
			children.add(helper(c));
		}
		Wrapper deepest = new Wrapper();
		Wrapper secondDeepest = new Wrapper();
		for(Wrapper w : children) {
			if(w.depth >= deepest.depth) {
				secondDeepest.node = deepest.node;
				secondDeepest.depth = deepest.depth;
				deepest.node = w.node;
				deepest.depth = w.depth;
			}
		}
		int depth = 1 + deepest.depth;
		if(secondDeepest.depth == deepest.depth) {
			return new Wrapper(root, depth);
		}
		
		return new Wrapper(deepest.node, depth);
	}
}

class Wrapper {
	TreeNode node;
	int depth;
	public Wrapper(TreeNode node, int h) {
		this.node = node;
		depth = h;
	}
	public Wrapper() {
		
	}
}
