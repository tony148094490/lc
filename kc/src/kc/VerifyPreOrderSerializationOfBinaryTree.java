package kc;


public class VerifyPreOrderSerializationOfBinaryTree {
    public boolean isValidSerialization(String preorder) {
    	String[] arr  = preorder.split(",");
    	
    	if(pre(arr, 0) != arr.length) return false;
    	
    	return true;
        
    }
 
    private int pre(String[] arr, int cur) {
    	
    	if(cur >= arr.length) return -1;
    	
    	if(arr[cur].equals("#")) return 1;

    	int sizeOfLeftChild = pre(arr, cur + 1);
    	    	
    	if(sizeOfLeftChild == -1 ) return -1;
    	
    	int sizeOfRightChild = pre(arr, cur + sizeOfLeftChild + 1);
    	
    	if(sizeOfRightChild == -1) return -1;

    	return sizeOfLeftChild + sizeOfRightChild + 1;

    }
    
    public static void main(String[] args) {
		String a = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		String b =  "1,#";
		String c =  "9,#,#,1";
		
		VerifyPreOrderSerializationOfBinaryTree d = new VerifyPreOrderSerializationOfBinaryTree();
		System.out.println(d.isValidSerialization(a));
		System.out.println(d.isValidSerialization(b));
		System.out.println(d.isValidSerialization(c));
		
	}
}
