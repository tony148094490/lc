package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        helper(nums,0,new ArrayList<Integer>(), res);
        return res;
        
    }
    private void helper(int[] nums, int curIndex, List<Integer> curRes, List<List<Integer>> res) {
    	if(curIndex == nums.length) return;
    	
    	for(int i = curIndex; i < nums.length; i++){
    		if(i>curIndex && nums[i] == nums[i-1]) continue;
    		curRes.add(nums[i]);
    		res.add(new ArrayList<Integer>(curRes));
    		helper(nums,i+1,curRes,res);
    		curRes.remove(curRes.size()-1);
    	}
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,2};
		SubsetsII x = new SubsetsII();
		System.out.println(x.subsetsWithDup(arr));
	}
	
}
