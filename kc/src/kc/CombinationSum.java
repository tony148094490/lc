package kc;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(arr.length < 0) return res;
		helper(arr, target,0, new ArrayList<Integer>(), res);
		return res;
	}
	
	private void helper(int[] arr, int target, int curIndex,
			ArrayList<Integer> cur, List<List<Integer>> res) {
		if(target == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		
		if(target < 0) return;
		
		for(int i = curIndex ; i < arr.length ; i++){
			if(arr[i] <= target) {
				cur.add(arr[i]);
				helper(arr, target - arr[i],i, cur, res);
				cur.remove(cur.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,6,7};
		CombinationSum c = new CombinationSum();
		System.out.println(c.combinationSum(arr, 7));
	}
}
