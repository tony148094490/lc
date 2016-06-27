package kc;

public class AddTwoNumbers {
	
	//Time O(m + n), Space O(m + n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	

        if(l1 == null) return l2;

        if(l2 == null) return l1;

        ListNode res = new ListNode(-1);

        ListNode current = res;

        int carry = 0;

        int sum = 0;

        int remainder = 0;

        

        while(l1!=null || l2!=null || carry!=0) {

            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

            remainder = sum % 10;

            carry = sum / 10;

            current.next = new ListNode(remainder);

            l1 = l1 == null ? null : l1.next;

            l2 = l2 == null ? null: l2.next;

            current = current.next;

        }

        return res.next;

    }
    
    
    public class vector{
    	public final int[] arr;
    	public vector(int[] nums) {
    		arr = nums;
    	}
    }
    
    public static void main (String[] args) {
    	AddTwoNumbers x = new AddTwoNumbers();
    	int[] arr = {1,2};
    	vector v = x.new vector(arr);
    	System.out.println(arr[0]);
    	System.out.println(v.arr[0]);
    	System.out.println();
    	arr[0] = 0;
    	System.out.println(arr[0]);
    	System.out.println(v.arr[0]);
    }
}
