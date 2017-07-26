package fb;

//Inorder --visite left -> root -> right
//First check right child, if it's not null, then the most left child of this right child is the answer
//Else check parent, if it is null, return null --because this is the root and it is the last node in inorder
//if not, if node.parent.left = node (node is the left child of its parent), return parent
//if node.parent.right = node(node is the right child of its parent), go up and 
//search ancester if any ancester is the left child of its parent, return parent
//else return null
public class BTFindNext {
	
	public TreeNodeWithParent getNext(TreeNodeWithParent cur) {
		if(cur.right == null) {
			if(cur.parent == null) return null;
			while(cur.parent != null && cur.parent.right == cur) {
				cur = cur.parent;
			}
			return cur.parent;
		} else {
			cur = cur.right;
			while(cur.left != null) {
				cur = cur.left;
			}
			return cur;
		}
	}

	public class TreeNodeWithParent {
		TreeNodeWithParent parent;
		TreeNodeWithParent left;
		TreeNodeWithParent right;
	}
}
