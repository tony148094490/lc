 package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 4) return res;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 3;i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1 ; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                
                int l = j + 1 ;
                int r = nums.length - 1;
                
                while(l < r) {
                    int curSum = nums[i] + nums[j] + nums[l] + nums[r];
                    if( curSum == target) {
                        List<Integer> newRes = new ArrayList<Integer>();
                        newRes.add(nums[i]);newRes.add(nums[j]);newRes.add(nums[l]);newRes.add(nums[r]);
                        res.add(newRes);
                        do {l++;} while(l < r && nums[l] == nums[l-1]);
                        do {r--;} while(l < r && nums[r] == nums[r+1]);
                    } else if (curSum < target) {
                        do {l++;} while(l < r && nums[l] == nums[l-1]);
                    } else {
                        do {r--;} while(l < r && nums[r] == nums[r+1]);
                    }
                }
            }
        }
        
        return res;
    }
    
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < A.length; i++) {
            for(int j = 0 ; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        int res = 0;
        for(int i = 0 ; i < C.length; i++) {
            for(int j = 0 ; j < D.length; j++) {
                int sum = C[i] + D[j];
                res += map.getOrDefault(-sum,0);
            }
        }
        return res;
    }
    
    
    public static void main(String[] args) {
    	FourSum s = new FourSum();
    	int[] x = {1,0,-1,0,-2,2};
    	System.out.println(s.fourSum(x, 0));
    }
}
