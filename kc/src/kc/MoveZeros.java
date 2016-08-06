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
    
    public static void main(String[] args) {
    	MoveZeros x = new MoveZeros();
    	int[] arr = {4,2,4,0,0,3,0,5,1,0};
    	x.moveZeroes(arr);
    	for(Integer a : arr) {
    		System.out.print(a + ",");
    		
    	}
	}
}
