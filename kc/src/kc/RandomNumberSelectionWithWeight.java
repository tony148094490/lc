package kc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomNumberSelectionWithWeight {
	public int get(int[] w) {
		if(w.length <= 1 || w == null) return 0;
		
		for(int i = 1; i < w.length; i++) {
			w[i] += w[i-1];
		}
		
		Random rand = new Random();

		int r = rand.nextInt(w[w.length-1]);
		return bs(w, 0, w.length-1, r);
	}
	
	private int bs(int[] w, int s, int e, int t) {
		while(s < e - 1) {
			int m = s + ( e - s ) / 2;
			if(w[m] > t) {
				e = m;
			} else {
				s = m;
			}
		}
		
		if(w[s] > t) {
			return s;
		}
		
		return e;
	}
	
	public static void main(String[] args) {
		RandomNumberSelectionWithWeight x = new RandomNumberSelectionWithWeight();
		int i = 1000;
		Map<Integer, Integer> map = new HashMap<>();
		while(i > 0){
			int[] arr = {1,2,4,5,1,3};
			int res = x.get(arr);
			map.put(res, map.getOrDefault(res, 0)+1);
			i--;
		}
		System.out.println(map);
	}
}
