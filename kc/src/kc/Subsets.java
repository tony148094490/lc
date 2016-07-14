package kc;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if(nums.length == 0) return res;
        helper(nums,0,new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(int[] nums, int currentIndex, List<Integer> curRes, List<List<Integer>> res) {
    	if(currentIndex == nums.length) {
    		return;
    	}
    	
    	for(int i = currentIndex; i < nums.length; i++) {
    		curRes.add(nums[i]);
    		res.add(new ArrayList<Integer>(curRes));
    		helper(nums,i+1,curRes,res);
    		curRes.remove(curRes.size()-1);
    	}
    	
    }
    
    
//    public List<List<Integer>> subsets2(int[] nums) {
//    	
//    }
    
	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] res = {1,2,3};
		System.out.println(s.subsets(res));
	}
}
