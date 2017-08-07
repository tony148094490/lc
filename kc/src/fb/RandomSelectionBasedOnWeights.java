package fb;

import java.util.Random;

public class RandomSelectionBasedOnWeights {
	public int random(int[] weights) {
		int n = weights.length;
		for(int i = 1; i < n ; i++) {
			weights[i] += weights[i-1];
		}
		Random rand = new Random();
		int selection = rand.nextInt(weights[weights.length-1]);
		
		return bs(weights, selection);
	}
	
	private int bs(int[] arr, int target) {
		int left = 0;
		int right = arr.length-1;
		while(left + 1 < right) {
			int m = left + (right - left);
			if(arr[m] <= target) {
				left = m;
			} else {
				right = m;
			}
		}
		
		if(arr[left] >= target) return left;
		return right;
	}
}
