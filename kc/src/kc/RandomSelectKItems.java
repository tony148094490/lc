package kc;

import java.util.Random;

public class RandomSelectKItems {
	public int[] getK(int[] arr, int k) {
		Random rand = new Random();

		int[] res = new int[k];
		for(int i = 0 ; i < k ; i++) {
			res[i] = arr[i];
		}
		for(int i = k ; i < arr.length; i++) {
			int index = rand.nextInt(i+1);
			if(index < k) {
				res[index] = arr[i];
			}
		}
		return res;
	}
}
