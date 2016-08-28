package kc;

import java.util.concurrent.ThreadLocalRandom;

public class ShuffleAnArray {
	
    final int[] arr;
    public ShuffleAnArray(int[] nums) {
        arr = nums;
    }
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length );
        for(int i = 0 ; i < newArr.length; i++){
        	int toSwap = ThreadLocalRandom.current().nextInt(0, i+1);
        	swap(newArr, i, toSwap);
        }
        return newArr;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
    	int[] arr = {1,2,3};
    	ShuffleAnArray x = new ShuffleAnArray(arr);
    	int[] a = x.shuffle();
    	for(int i = 0 ; i < a.length; i++){
    		System.out.print(a[i] + ",");
    	}
    	System.out.println();
    	a = x.reset();
    	for(int i = 0 ; i < a.length; i++){
    		System.out.print(a[i] + ",");
    	}
    	System.out.println();

    	
	}
}
