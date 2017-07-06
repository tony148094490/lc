package airbnb;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://tinyurl.com/y8s8xtpt
//https://tinyurl.com/y76cwhlw // detailed description and context
// follow up: followup是|xi-yi|*i求最小。

/*
 * Given an array of numbers A = [x1, x2, ..., xn] and T = Round(x1+x2+... +xn)
We want to find a way to round each element in A such that after rounding we get a new array B = [y1, y2, ...., yn]
 such that y1+y2+...+yn = T where  yi = Floor(xi) or Ceil(xi), ceiling or floor of xi.
We also want to minimize sum |x_i-y_i|

Test case: A ={1.2, 2.3, 3.4}, T = 7, Output = {1,2,4}; 
 */
public class RoundNumbers {
	public int[] round(double[] nums, int target) {
		// assumption: for numbers that cannot be rounded, i.e 4.0, 5.0, we leave them out because they shouldn't be able to
		// contribute to the differences of the result, so we have assumption on the target, this should be a valid range
		// where it should not exceed [sum of all floor(n), sum of all ceiling(n)], otherwise, we need a small tweak
		// float/double number comparasion should be careful
		// this is VERY tricky, if we decide to floor the number, we will need to rank it based ceil(number) - number, instead of number - floor(number)
		// so if after out initial iteration we floored 3.4 to 3.0 and 3.45 to 3.0 and we are less than target, we will need to ceiling 3.45 first
		Comparator<Node> comp = new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				if(a.absoluteDiff <= b.absoluteDiff) {
					return -1;
				}
				return 1;
			}
		};

		int[] res = new int[nums.length];

		// store all the numbers that are initially floored, and rank them based on the distance to the ceiling
		PriorityQueue<Node> floorPQ = new PriorityQueue<>(comp);
		
		// store all the numbers that are initially ceilinged, and rank them based on the distance to the floor
		PriorityQueue<Node> ceilingPQ = new PriorityQueue<>(comp);
		
		double epsi = 0.000000001;
		
		// running sum
		int total = 0;
		
		// populate floorPQ and ceilingPQ, round to nearest number and sort based on abs diff
		for(int i = 0 ; i < nums.length; i++) {
			if(Math.abs(Math.ceil(nums[i]) - nums[i]) <= epsi) {
				res[i] = (int) Math.ceil(nums[i]);// ceil or floor both are okay
			} else if(Math.ceil(nums[i]) - nums[i] <= nums[i] - Math.floor(nums[i])) {
				ceilingPQ.add(new Node(nums[i], i));
				res[i] = (int) Math.ceil(nums[i]);
			} else {
				floorPQ.add(new Node(nums[i], i));
				res[i] = (int) Math.floor(nums[i]);
			}
			total += res[i];
		}
		
		if(total == target) {
			return res;
		} else if(total < target) {
			// need to change some floors to ceilings
			while(total < target) {
				Node n = floorPQ.poll();
				res[n.index] += 1;
				total += 1;
			}
			return res;
		} else {
			// need to change some ceilings to floors
			while(total > target) {
				Node n = ceilingPQ.poll();
				res[n.index] -= 1;
				total -= 1;
			}
			return res;
		}
		
		// one optimization for this: instead of using PQs, we just use two ordinary arrays. then after
		// getting the differences (say k) and the corresponding array(say the ceiling), use 'get Kth smallest' algo (quick select)
		// to get the kth index, which can optimize this to avg O(n)
	}
	
	public class Node {
		double number;
		
		double absoluteDiff;
		int index;
		public Node(double n, int i) {
			number = n;
			index = i;
			
			// this is ticky, we store the absolute difference to the opposite direction, i.e if it's 3.4, we store 0.6;
			absoluteDiff = Math.max(Math.ceil(n) - n, n - Math.floor(n));
		}
	}
	
	public static void main(String[] args) {
		double[] input = {1.2, 2.3, 3.4, 4.0};
		int target = 13; 
		RoundNumbers r = new RoundNumbers();
		int[] output = r.round(input, target);
		for(int i : output) {
			System.out.print(i + ",");
		}
	}
	
}
