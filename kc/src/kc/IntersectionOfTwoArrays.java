package kc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> x = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {

        	while( i< nums1.length && ((i > 0 && nums1[i] == nums1[i-1])||nums1[i] < nums2[j])) i++;
                if(i == nums1.length) break;
                while( j< nums2.length && ((j > 0 && nums2[j] == nums2[j-1])||nums2[j] < nums1[i])) j++;
                if(j == nums2.length) break;
            
                if(nums1[i] == nums2[j]) {
                	x.add(nums1[i]);
                	i++;
                	j++;
                } else if(nums1[i] < nums2[j]) {
                	while(i < nums1.length && nums1[i] < nums2[j])
                	i++;
                } else {
                	while(j < nums2.length && nums2[j] < nums1[i])
                	j++;
                }
        }
        int[] res = new int[x.size()];
        for(int k = 0 ; k< res.length; k++) {
            res[k] = x.get(k);
        }
        return res;
    }
    
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> x = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {

//        		while( i< nums1.length && ((i > 0 && nums1[i] == nums1[i-1])||nums1[i] < nums2[j])) i++;
//                if(i == nums1.length) break;
//                while( j< nums2.length && ((j > 0 && nums2[j] == nums2[j-1])||nums2[j] < nums1[i])) j++;
//                if(j == nums2.length) break;
                if(nums1[i] == nums2[j]) {
                	x.add(nums1[i]);
                	i++;
                	j++;
                } else if(nums1[i] < nums2[j]) {
                	while(i < nums1.length && nums1[i] < nums2[j])
                	i++;
                } else {
                	while(j < nums2.length && nums2[j] < nums1[i])
                	j++;
                }
        }
        int[] res = new int[x.size()];
        for(int k = 0 ; k< res.length; k++) {
            res[k] = x.get(k);
        }
        return res;
    }
    
    public static void main(String[] args) {
		int[] a = {1,2,2,2,1};
		int[] b = {2,2};
		IntersectionOfTwoArrays x = new IntersectionOfTwoArrays();
		int[] res = x.intersect(a, b);
		for(Integer c : res) System.out.print(c + ",");
	}
}
