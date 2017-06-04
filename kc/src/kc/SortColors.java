package kc;

public class SortColors {
    //red 0 , white 1, blue 2
	public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int i = 0;
        while(i <= blue) {
        	if(nums[i] == 1) {
        		i++;
        	} else if(nums[i] == 0) {
        		swap(nums,red,i);
        		red++;
        		i++;
        	} else {
        		swap(nums,i,blue);
        		blue--;
        	}
        }
    }
	
	private void swap(int[] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
	
	private void sort(int[] nums) {
		int zero = 0;
		int two = nums.length-1;
		int one = 0;
		while(one <= two) {
			if(nums[one] == 0) {
				swap(nums, one, zero);
				one++;
				zero++;
			} else if (nums[one] == 2) {
				swap(nums,one, two);
				two--;
			} else {
				one++;
			}
		}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0};
		SortColors x = new SortColors();
		x.sortColors(arr);
		for(Integer a : arr) System.out.print(a);
	}

}
