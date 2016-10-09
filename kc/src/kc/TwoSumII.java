package kc;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that 
they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 
 *
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
    	int[] res = new int[2];
        if(numbers.length < 2) return res;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < numbers.length; i++) {
        	if(map.containsKey(numbers[i])) {
        		res[0] = map.get(numbers[i]) + 1;
        		res[1] = i + 1;
        		return res;
        	} else {
        		map.put(target - numbers[i], i);
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
    	TwoSumII x = new TwoSumII();
    	int[] arr = {2,7,11,15};
    	int[] res = x.twoSum(arr, 9);
    	System.out.println(res[0] + "," + res[1]);
    }
}
