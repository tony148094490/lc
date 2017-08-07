package fb;

public class LLRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode cur = head;
        RandomListNode next = head.next;
        while(cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            cur.next = newNode;
            newNode.next = next;
            
            cur = next;
            if(next != null) next = next.next;
        }
        
        cur = head;
        while(cur != null) {
            
            if(cur.next != null && cur.random != null)
            cur.next.random = cur.random.next;
            
            
            cur = cur.next.next;
        }
        
        cur = head;
        RandomListNode newCur = head.next;
        RandomListNode res = newCur;
        while(cur != null) {
            cur.next = newCur.next;
            if(newCur.next != null) newCur.next = newCur.next.next;
            cur = cur.next;
            newCur = newCur.next;
        }
        return res;
    }
    
    public class RandomListNode {
    	RandomListNode next, random;
    	int label;
    	public RandomListNode(int v) {
    		label = v;
    	}
    }
}
