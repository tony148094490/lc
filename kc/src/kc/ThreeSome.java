package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSome {
	
	//Space O(1), Time O(nlogn + n^2)
	public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			
			Arrays.sort(nums);
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int target = 0;
			for(int i = 0 ; i < nums.length - 2 && nums[i] <= 0 ; i++) {
				if(i > 0 && i < nums.length - 2 && nums[i] == nums[i-1]) continue;
				
				map = new HashMap<Integer, Integer>();
				
				for (int j = i + 1 ; j < nums.length; j++){
					
					if(nums[i] == Integer.MIN_VALUE) {
						if(nums[j] > 0 && map.containsKey(0 - (nums[i] + nums[j]))) {
							if(map.get(target-nums[j]) > 0) continue;
							map.put(target-nums[j], 1);
							List<Integer> newList = new ArrayList<Integer>();
							newList.add(nums[i]);
							newList.add(0 - (nums[i] + nums[j]));
							newList.add(nums[j]);
							res.add(newList);
						}
					}else {
						target = -1 * nums[i];
						if(map.containsKey(target - nums[j])){
							if(map.get(target-nums[j]) > 0) continue;
							map.put(target- nums[j], 1);
							List<Integer> newList = new ArrayList<Integer>();
							newList.add(nums[i]);
							newList.add(0 - nums[i] - nums[j]);
							newList.add(nums[j]);
							res.add(newList);
						} else {
							map.put(nums[j], 0);
						}
					}
					
				}
			}
			return res;
	}

	
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);

		for(int i = 0 ; i < nums.length - 2 && nums[i] <= 0 ; i++) {
			if(i > 0 && i < nums.length - 2 && nums[i] == nums[i-1]) continue;
			
			int left = i + 1;
			int right = nums.length - 1;
		
			while(left < right){
				if(nums[i] + nums[left] + nums[right] > 0){
					right--;
				} else if (nums[i] + nums[left] + nums[right] < 0) {
					left++;
				} else {
					List<Integer> newList = new ArrayList<Integer>();
					newList.add(nums[i]);
					newList.add(nums[left]);
					newList.add(nums[right]);
					res.add(newList);
					do {left++;} while(left < right && nums[left] == nums[left-1]);
					do {right--;} while(left < right && nums[right] == nums[right+1]);
				}
			}
		}
		
		return res;	
		
	}
	
	public static void main(String[] args) {
		int[] arr = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		ThreeSome x = new ThreeSome();
		
		System.out.println(x.threeSum2(arr));
	}
}

