package airbnb;

import java.util.ArrayList;

// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=279191
// not sure if below impl is correct 
public class QueueWithArrayList {

	Node root = new Node();
	Node tail = root;
	
	public void add(int element) {
		if(tail.numbers.size() <= 9) {
			tail.numbers.add(element);
		} else {
			tail.next.numbers.add(element);
			tail = tail.next;
		}

	}
	
	public int poll() throws Exception {
		int res = 0;
		if(root.numbers.size() > 1) {
			res = root.numbers.remove(0);
		} else if (root.numbers.size() == 1){
			res = root.numbers.remove(0);
			root = root.next;
		} else {
			throw new Exception("Empty queue");
		}
		return res;
	}
	
	public boolean isEmpty() {
		return root.numbers.isEmpty();
	}
	
	public class Node {
		Node next = new Node();
		ArrayList<Integer> numbers = new ArrayList<>();
	}
}
