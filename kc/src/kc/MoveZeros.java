package kc;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        for(int i = 0 ; i < nums.length; i++ ) {
            if(nums[i] != 0) {
                nums[nonZero] = nums[i];
                nonZero++;
            }
        }
        for(int i = nonZero; i < nums.length; i++){
            nums[i] = 0;
        }
    }
    
    private void removeChar(char[] arr, char c) {
    	int slow = 0;
    	int fast = 0;
    	while(fast < arr.length) {
    		while(slow < arr.length && arr[slow] != c) slow++;
    		fast = slow;
    		while(fast < arr.length && arr[fast] == c) fast++;
    		if(fast < arr.length) {
    			arr[slow] = arr[fast];
    			arr[fast] = c;
    			fast++;
    			slow++;
    		}
    	}
    }
    
    private int move(int[] arr) {
    	int left = 0;
    	int right = arr.length-1;
    	while(left <= right) {
        	while(left <= right && left < arr.length && arr[left] != 0) left++;
        	while(left <= right && right >= 0 && arr[right] == 0) right--;
        	if(left <= right) {
        		arr[left] = arr[right];
        		right--;
        		left++;
        	}
    	}
    	return left;
    }
    
    public static void main(String[] args) {
//    	MoveZeros x = new MoveZeros();
//    	int[] arr = {4,2,4,0,0,3,0,5,1,0};
//    	x.moveZeroes(arr);
//    	for(Integer a : arr) {
//    		System.out.print(a + ",");
//    		
//    	}
	}
}

