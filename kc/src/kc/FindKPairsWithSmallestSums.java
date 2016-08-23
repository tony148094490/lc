package kc;

import java.util.ArrayList;
import java.util.List;

public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<int[]> res = new ArrayList<int[]>();
    int counter = 0;
//    if(nums1.length < nums2.length) {
    	int[] rows = new int[nums1.length];
    	while(counter < k) {
    		int minimum = Integer.MAX_VALUE;
    		int curR = -1, curC = -1;
    		for(int i = 0 ; i < rows.length; i++) {
    			if(rows[i] >= nums2.length) continue;
    			if(nums1[i] + nums2[rows[i]] < minimum) {
    				minimum = nums1[i] + nums2[rows[i]];
    				curR = i;
    				curC = rows[i];
    			}
    		}
    		if(curR == -1) break;
    		int[] curMin = {nums1[curR], nums2[curC]};
    		res.add(curMin);
    		rows[curR]++;
    		counter++;
    	}
    	return res;
 
//    } else {
//    }
    }
    
    public static void main(String[] args) {
		int[] nums1 = {1,3,4,5,6,7,8,9,10};
		int[] nums2 = {2,4,5,6,7,8,9};
		FindKPairsWithSmallestSums x = new FindKPairsWithSmallestSums();
		List<int[]> res = x.kSmallestPairs(nums1, nums2, 10);
		for(int[] arr : res) {
			System.out.print("(" + arr[0] + "," + arr[1] + ") ");
		}
		
	}
}
