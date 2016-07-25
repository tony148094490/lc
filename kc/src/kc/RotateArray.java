package kc;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k==0) return;
        int[] temp = new int[k];
        for(int i = 0; i < k; i++){
            temp[i] = nums[nums.length - (k-i)];
        }
        for(int i = nums.length - k - 1 ; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for(int i = 0 ; i < k; i++){
            nums[i] = temp[i];
        }
    }
    
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        if(k==0) return;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    
    private void reverse(int[] arr, int l, int r) {
        int temp = 0;
        while(l<r){
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            l++;
            r--;
        }
    }
    
    public static void main(String[] args) {
		RotateArray x= new RotateArray();
		int[] arr = {1,2,3,4,5};
		x.rotate(arr, 3);
		for(Integer a : arr) {
			System.out.print(a + ",");
		}
	}
}
