package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public List<List<Integer>> combinationSum2(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(arr.length < 0) return res;
		Arrays.sort(arr);
		helper(arr, target, 0 , new ArrayList<Integer>(), res);
		return res;
	}
	
	private void helper(int[] arr, int target, int curIndex, ArrayList<Integer> curRes,
			List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(curRes));
			return;
		}
		
		if(target < 0) return;
		
		for(int i = curIndex; i < arr.length ; i++) {
			if (i > curIndex && arr[i] == arr[i-1]) continue;
			if(arr[i] <= target) {
				curRes.add(arr[i]);
				helper(arr,target - arr[i], i + 1, curRes, res);
				curRes.remove(curRes.size()-1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {10,1,2,7,6,1,5};
		CombinationSum2 x = new CombinationSum2();
		System.out.println(x.combinationSum2(arr, 8));
	}
}
