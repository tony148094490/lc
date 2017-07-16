package airbnb;

import java.util.ArrayList;

// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=279191
// not sure if below impl is correct 
public class QueueWithArrayList {

	Node root = new Node();
	Node tail = root;

	public void add(int element) {

		if(tail.array.size() == 10) {
			tail.next = new Node();
			tail = tail.next;
			tail.array.add(element);
		} else {
			tail.array.add(element);
		}
	}

	public int poll() throws Exception {
		if(isEmpty()) throw new Exception();
		int element = root.array.remove(0);
		if(root.array.size() == 0) {
			root = root.next;
			if(root == null) {
				root = new Node();
				tail = root; // tricky, tail needs to be updated as well in case root catches up tail
			}
		}
		return element;
	}

	public boolean isEmpty() {
		if(root == null || root.array.size() == 0) return false;
		return true;
	}

	public class Node {
		Node next;
		ArrayList<Integer> array;
		public Node() {
			array = new ArrayList<>();
		}
	}

}
