package airbnb;
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=273149
// http://baike.baidu.com/item/%E5%86%B0%E9%9B%B9%E7%8C%9C%E6%83%B3#3_2

import java.util.HashMap;
import java.util.Map;

// very similar to https://leetcode.com/problems/integer-replacement/#/description
public class NumberConversion {
	// dfs + cache
	// formula is : n/2     (when n % 2 == 0) 
	//              3*n + 1 (when n % 2 != 0)
	
	Map<Integer, Integer> cache = new HashMap<>();
	int max = 0;
	public int maxSteps(int top) {
		for(int i = 1; i <= top; i++) {
			dfs(i);
		}
		return max;
	}
	
	private int dfs(int n) {
		if(cache.containsKey(n)) return cache.get(n);
		if(n == 1) return 1;
		int number = 0;
		if(n % 2 == 0) {
			number = dfs(n / 2) + 1;
		} else {
			number = dfs(3 * n + 1) + 1;
		}
		cache.put(n, number);
		max = Math.max(max, number);
		return number;
	}
	
	public static void main(String[] args) {
		NumberConversion x = new NumberConversion();
		System.out.println(x.maxSteps(7));
	}
}
