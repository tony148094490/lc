package kc;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums.length == 0) return res;

        int counterOne = 0;
        int counterTwo = 0;
        int resOne = 0;
        int resTwo = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == resOne) {
        		counterOne++;
        	} else if(nums[i] == resTwo) {
        		counterTwo++;
        	} else if(counterOne == 0){
        		counterOne++;
        		resOne = nums[i];
        	} else if(counterTwo == 0){
        		counterTwo++;
        		resTwo = nums[i];
        	} else {
        		counterOne--;
        		counterTwo--;
        	}
        }

        counterOne = 0;
        counterTwo = 0;
        for(Integer x : nums) {
            if(x == resOne) counterOne++;
            if(x == resTwo) counterTwo++;
        }
        
        if(counterOne > (double) nums.length / 3 ) res.add(resOne);
        if(resOne != resTwo)
        if(counterTwo > (double) nums.length / 3) res.add(resTwo);

        return res;
    }
    
    public static void main(String[] args) {
		MajorityElementII x = new MajorityElementII();
		
		int[] arr = {2,2,1,3};
		System.out.println(x.majorityElement(arr));
		
	}
}
