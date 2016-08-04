package kc;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length < 2) return nums;
        int[] arr = new int[nums.length];
        arr[0] = 1;
        arr[nums.length-1] = 1;
        int curProduct = 1;
        for(int i = 1 ; i < nums.length ;i++ ){
            arr[i] = curProduct * nums[i-1];
            curProduct = arr[i];
        }
        
        curProduct = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--) {
            arr[i] = arr[i] * curProduct;
            curProduct = curProduct * nums[i];
        }
        
        return arr;
    }
    
    public static void main(String[] args) {
		ProductExceptSelf x = new ProductExceptSelf();
		int[] arr = {1,2,3,4};
		int[] res = x.productExceptSelf(arr);
		for(Integer a : res) {
			System.out.print(a + ",");
		}
	}
}
