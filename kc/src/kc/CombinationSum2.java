package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    
    public void helper(int[] arr, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if(target == 0) {
            if(path.size() != 0) {
                res.add(new ArrayList<Integer>(path));
            }
            return;
        }
        if(cur == arr.length) return;
        
        for(int i = cur; i < arr.length && arr[i] <= target ;i++) {
            if(i > cur && arr[i] == arr[i-1]) continue;
            path.add(arr[i]);
            helper(arr, i + 1 , target - arr[i], path, res);
            path.remove(path.size()-1);
        }
    }
	
	
	public static void main(String[] args) {
		int[] arr = {10,1,2,7,6,1,5};
		CombinationSum2 x = new CombinationSum2();
		System.out.println(x.combinationSum2(arr, 8));
	}
}
