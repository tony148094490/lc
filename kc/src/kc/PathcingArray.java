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
        long nextTarget = 1;
        int index = 0;
        int patchNeeded = 0;
        while(nextTarget <= n) {
        	// we either need a patch to get n covered or advance our target with what we have
        	// assumption is that any value smaller than nextTarget is already covered
        	// question is can we cover nextTarget or not?
        	
            if(index < nums.length && nums[index] <= nextTarget) { 
            	nextTarget += nums[index]; // so we can cover nextTarget and expand it to nextTarget + nums[index]
                index++;
            } else {
                patchNeeded++;// so we can cover nextTarget safely and expand it to nextTarget + nextTarget
                // by adding a particular number, it could be anything like 2^N, we can reach to nextTarget * 2 - 1
                
                nextTarget *= 2; // it's because we can already cover from 1 to nextTarget 
                				//+ (nextTarget -1), which means our next target is nextTarget + nextTarget.
                // it's actually nextTarget - 1(the one we already covered)
                // + nextTarget(the number we are patching in) + 1(the target)
            }
        }
        return patchNeeded;
    }
    
    public static void main(String[] args) {
    	int[] arr = {1, 2, 4,5};
    	PathcingArray x = new PathcingArray();
    	
    	System.out.println(x.minPatches(arr, 25));
    	
    }
}
