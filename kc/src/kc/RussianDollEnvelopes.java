package kc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
 * One envelope can fit into another if and only if both the width and height of one envelope
 *  is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can
 Russian doll is 3 ([2,3] => [5,4] => [6,7]). 
 */
public class RussianDollEnvelopes {
	int[] max;	
	// > 800ms 
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length < 1) return 0;
        max = new int[envelopes.length];
        int res = 1;
        for(int i = 0 ; i < envelopes.length; i++) {
        	res = Math.max(res, getMax(envelopes, i, -1));
        }
        return res;
    }
    
    private int getMax(int[][] arr, int current, int previous) {
    	if(current < 0 || current >= arr.length) return 0;
    	if(previous >= 0 && (arr[current][0] >= arr[previous][0] || arr[current][1] >= arr[previous][1])) return 0;
    	if(max[current] != 0) return max[current];
    	
    	int res = 0;
    	for(int i = 0 ; i < arr.length ;i++) {
    		if(i == current || i == previous) continue;
    		res = Math.max(res, getMax(arr, i, current));
    	}
    	max[current] = res + 1;
    	return res + 1;
    }
    
    // > 510 ms
    public int maxEnvelopes2(int[][] envelopes) {
    	if(envelopes.length < 1) return 0;
        Comparator<int[]> comp = new Comparator<int[]>(){
        		@Override
        		public int compare(int[] a, int[] b) {
        			return a[0] - b[0];
        		}
        };
        int res = 1;
        Arrays.sort(envelopes, comp);
        int[] dp = new int[envelopes.length];
        for(int i = 0 ; i < envelopes.length; i++) {
        	dp[i] = 1;
        	for(int j = 0 ; j < i; j++) {
        		if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
        	}
        	res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    // key is to descend on height so that lower height can replace higher height when we have a width tie
    // otherwise lower height will be calculated within higher height with same width.
    // it's a bit like insertion sort on heights, very not intuitive
    // 18ms  nlogn
    public int maxEnvelopes3(int[][] envelopes) {
        int r = envelopes.length; 
        if(r == 0) return 0;
        int c = envelopes[0].length;
        if(c == 0) return 0;
        Comparator<int[]> comp = new Comparator<int[]>(){
          @Override
          public int compare(int[] a, int[] b) {
               if(a[0] == b[0]) return b[1] - a[1];
               return a[0] - b[0];
          }
        };
        Arrays.sort(envelopes, comp);
        LinkedList<Integer> heights = new LinkedList<Integer>();
        //insertion sort(updates) on heights 
        for(int[] env : envelopes) {
            int left = 0;
            int right = heights.size()-1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(heights.get(mid) < env[1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            if(left == heights.size()) {
                heights.add(env[1]);
            } else {
                heights.set(left, env[1]);
            }
        
        }
        return heights.size();
    }
    
    public static void main(String[] args) {
    	RussianDollEnvelopes x = new RussianDollEnvelopes();
    	int[][] arr = new int[4][2];
    	//[[5,4],[6,4],[6,7],[2,3]]
    	arr[0][0] = 5;
    	arr[0][1] = 4;
    	
    	arr[1][0] = 6;
    	arr[1][1] = 4;
    	
    	arr[2][0] = 6;
    	arr[2][1] = 7;
    	
    	arr[3][0] = 2;
    	arr[3][1] = 3;
    	
    	System.out.println(x.maxEnvelopes3(arr));
    }
}
