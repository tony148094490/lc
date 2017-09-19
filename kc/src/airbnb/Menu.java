package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://tinyurl.com/y76fut44
// neds to ask if one dish can be ordered multiple times
//  题目就是那个餐馆点餐的问题，有个menu, 然后价格是double,给一个总的价格，让找出menu里面所有的combo可以组成这个总价。
/*
 *  给了一个餐馆的 menu, 上面各种食物的价格两位小数，一个人有一定金额的钱，如何点菜才能花完？列出所有可能的组合 https://xkcd.com/287/
 *  
1是把每个数都乘以100 免去double类型的比较
2是用一个小量来表示趋于接近
 *  
 *  output may(very likely) ask for ordered and no duplicate (duplicate may mean dish duplicate, not price duplciate)
 *  
 *  // "run了，但是因为没有排序所以结果有duplicates，technically没有成功" -- so looks like we need to consider some sort of de-dupe logic, likely de-dupe price
 *  // "当时给的所有菜名价格都不一样，所以也就没有考虑这个。但是我猜面试官会把相同价格不同菜名算作非重复解吧，这样按价格排序比较合理吧。不过我没有做出来，所以掩面"
 *  
 */
public class Menu {
	private static final double e = 0.000001;
	public List<List<Double>> getCombo(double[] menu, double target) {
		Arrays.sort(menu);
		List<List<Double>> res = new ArrayList<>();
		dfs(menu, 0, 0, target, new ArrayList<>(), res);
		return res;
	}

	private void dfs(double[] menu, int index, double cur, double target, List<Double> path, List<List<Double>> res) {
		if(eq(target, cur)) {
			res.add(new ArrayList<>(path));
			return;
		}

		if(target < cur) return;

		for(int i = index; i < menu.length; i++) {
			if(i > index && eq(menu[i], menu[i-1])) continue;
			path.add(menu[i]);
			dfs(menu, i + 1, menu[i] + cur, target, path, res);
			path.remove(path.size()-1);
		}

	}

	private boolean eq(double a, double b) {
		if(Math.abs(a - b) < e) return true;
		return false;
	}
	
	
	// from the web
	   public static List<List<Double>> getCombinations(double[] prices, double target) {
	        if (prices == null || prices.length == 0 || target < 0) return Collections.emptyList();
	        int[] priceInCents = new int[prices.length];
	        int targetInCents = (int) Math.round((target * 100));
	        List<List<Double>> result = new ArrayList<>();
	        Arrays.sort(prices);
	        for (int i = 0; i < prices.length; i++) {
	            priceInCents[i] = (int) Math.round((prices[i] * 100));
	        }
	        backtracking(result, prices, priceInCents, targetInCents, 0, new ArrayList<Double>());
	        return result;
	    }

	    public static void backtracking(List<List<Double>> result, double[] prices,
	                                    int[] priceInCents, int target, int index, List<Double> path) {
	        if (target == 0) {
	            result.add(new ArrayList<>(path));
	        } else {
	            for (int i = index; i < priceInCents.length; i++) {
	                if ((i > index && priceInCents[i] == priceInCents[i - 1])|| target < priceInCents[i]) continue;
	                path.add(prices[i]);
	                backtracking(result, prices, priceInCents, target - priceInCents[i], i + 1, path);
	                path.remove(path.size() - 1);
	            }
	        }
	    }
	    
	    
//	public List<List<Double>> getCombo3(double[] menu, double target) {
//		
//	}
	
	

	
	public static void main(String[] args) {
		double[] prices = {0.32,1.30,3.37, 0.65,0.95,2.30};
		Menu x = new Menu();
		System.out.println(x.getCombo(prices, 2.57));
		System.out.println(getCombinations(prices, 2.57));
		System.out.println();
        double[] prices2 = {10.02,1.11,2.22,3.01,4.02,2.00,5.03};
		System.out.println(x.getCombo(prices2, 7.03));
		System.out.println(getCombinations(prices2, 7.03));

	}
}
