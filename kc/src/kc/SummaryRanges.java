package kc;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length == 0) return res;
        int start = nums[0];
        int end = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            if(nums[i] > end+1) {
                //construct a new string;
                if(start == end) {
                    res.add(String.valueOf(start));
                } else {
                    String str = start + "->" + end;
                    res.add(str);
                }
                start = nums[i];
                end = nums[i];
            } else {
                while(i < nums.length && nums[i] == end+1) {
                    end++;
                    i++;
                }
                if(i == nums.length) {
                    end = nums[nums.length-1];    
                }
                
                if(start == end) {
                    res.add(String.valueOf(start));
                } else {
                    String str = start + "->" + end;
                    res.add(str);
                }
                
                if(i < nums.length){
                    start = nums[i];
                    end = nums[i];
                }
            }
        }
        if(start == end) {
        	res.add(String.valueOf(start));
        }
        return res;
    }
    
    public static void main(String[] args) {
		int[] arr = {0,1,2,4,5,7};
		SummaryRanges x = new SummaryRanges();
		System.out.println(x.summaryRanges(arr));
	}
}
