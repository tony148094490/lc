package kc;

import java.util.ArrayList;
import java.util.List;
// idea is k way merge
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        int[] colProgress = new int[nums1.length];
        while(k > 0) {
            int minC = -1;
            int minR = -1;
            int min = Integer.MAX_VALUE;
            for(int i = 0 ; i < nums1.length; i++) {
                if(colProgress[i] >= nums2.length) continue;
                if(nums1[i] + nums2[colProgress[i]] < min) {
                    minR = i;
                    minC = colProgress[i];
                    min = nums1[i] + nums2[colProgress[i]];
                }
            }
            if(minR == -1) return res;
            res.add(new int[]{nums1[minR], nums2[minC]});
            colProgress[minR]++;
            k--;
        }
        return res;
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
