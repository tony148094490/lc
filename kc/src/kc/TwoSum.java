package kc;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	// time n ^ 2 + space 1
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int remainder = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (remainder == nums[j]) {
                    int[] res = new int[2];
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        
        return null;
    }


    // n * log(n) time + n space
    public int[] twoSum1(int[] nums, int target) {
    	int[] arr = nums;
    	quickSort(arr);
    	int a = -1;
    	int b = -1;
    	int i = 0;
    	int j = nums.length-1;
    	while(i<j){
    		if(arr[i] + arr[j] == target) {
    			for(int k = 0; k < nums.length;k++) {
    				if (a == -1 && arr[i] == nums[k]){
    					a = k;
    				} else if (arr[j] == nums[k]) {
    					b = k;
    				}
    			}
    		} else if (arr[i] + arr[j] > target) {
    			j--;
    		} else {
    			i++;
    		}
    	}
    	//sort the array first
    	int[] res = new int[2];
    	res[0] = a;
    	res[1] = b;
    	return res;
    }


    // n time + n space
    public int[] twoSum2(int[] nums, int target) {
    	int[] res = new int[2];
    	if (nums != null) {
    		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    		for (int i = 0; i < nums.length; i++) {
    			if (map.containsKey(target - nums[i])) {
    				res[1] = i;
    				res[0] = map.get(target - nums[i]);
    				break;
    			}
    			map.put(nums[i], i);
    		}
    	}
    	return res;
    }

    
    
    public void quickSort(int[] nums) {
    	quickSort(nums, 0, nums.length-1);
    }
    
    private void quickSort(int[] nums, int left, int right) {
    	if (left > right) 
    		return;
    	
    	int sortedPosition = partition(nums, left, left + 1, right);
    	quickSort(nums, left, sortedPosition - 1);
    	quickSort(nums, sortedPosition + 1, right);
    }
    
    private int partition(int[] nums, int pivot, int left, int right) {
    	
    	int start = pivot;
    	int end = right;
    	
    	while(true) {
    		while(left <= end && nums[left] < nums[pivot]) {
    			left++;
    		}
    		
    		while(right >= start && nums[right] > nums[pivot] ) {
    			right--;
    		}
    		
    		if(left < right) {
    			swap(nums,left,right);
    		} else {
    			break;
    		}
    	}
    	
    	swap(nums,pivot,right);
    	return right;
    	
    }
    
    private void swap(int[] nums, int left, int right) {
    	int temp = nums[left];
    	nums[left] = nums[right];
    	nums[right] = temp;
    }
    
    
}
