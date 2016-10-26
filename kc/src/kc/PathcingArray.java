package kc;


public class PathcingArray {
	
	/**
	 * idea is the maximum number of patching needed is 1,2,4,8,16...2^n...N 
	 * So if nums[i] is smaller than one of the number less than N, for example 7, we then can reach to 14 without help of 8. 
	 * Basically, if N lies in anywhere between 7 to 14, if we only have 7 in the array, we only need three patching. While
	 * if we don't have 7, we would need 4 numbers including 8. 
	 * so we start from 1 and keep checking the current maximum number reachable against numbers in array, if the number in
	 * array is smaller, then it means that we don't need to patch the next number and reach all the way to 2n with
	 * an additional patching and can just add the number in array instead to 'save' one patching and reach to current+nums[i]
	 * The reason we can say we are able to reach to current+nums[i] is that we've already reached a number greater than nums[i]
	 * and all numbers smaller than nums[i] can be represented with some numbers as well.
	 * */
    public int minPatches(int[] nums, int n) {
    	long currentMaxReachable = 1;
    	int index = 0;
    	int patches = 0;
    	
    	while(currentMaxReachable <= n) {
    		if(index < nums.length && nums[index] <= currentMaxReachable) {
    			currentMaxReachable += nums[index];
    			index++;
    		} else {
    			currentMaxReachable *= 2;
    			patches++;
    		}
    	}
    	
    	return patches;
    }
    
    public static void main(String[] args) {
    	int[] arr = {1, 5, 10};
    	PathcingArray x = new PathcingArray();
    	
    	System.out.println(x.minPatches(arr, 20));
    	
    }
}
