package kc;

public class PopulatingNextRightPointer {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode firstOfNextLevel = null;
        if(root.left != null) {
        	firstOfNextLevel = root.left;
        } else {
        	firstOfNextLevel = root.right;
        }
        
        TreeLinkNode curParent = root;
        
        while(firstOfNextLevel != null) {
        	TreeLinkNode curChild = firstOfNextLevel;
        	while(curParent != null) {
        		if(curParent.left != null && curParent.left != curChild) {
        			curChild.next = curParent.left;
        			curChild = curChild.next;
        			if(curParent.right != null) {
        				curChild.next = curParent.right;
        				curChild = curChild.next;
        			}
        		} else if(curParent.right != null && curParent.right != curChild) {
        			curChild.next = curParent.right;
        			curChild = curChild.next;
        		}
        			curParent = curParent.next;
        	}
        	while(firstOfNextLevel != null && firstOfNextLevel.left == null && firstOfNextLevel.right == null) {
        		firstOfNextLevel = firstOfNextLevel.next;
        	}
        	
        	
        	if(firstOfNextLevel != null) {
        		curParent = firstOfNextLevel;
        		if(firstOfNextLevel.left != null) {
        			firstOfNextLevel = firstOfNextLevel.left;
        		} else {
        			firstOfNextLevel = firstOfNextLevel.right;
        		}
        	}
        }
    }
    
    public static void main(String[] args) {
		
	}
}
