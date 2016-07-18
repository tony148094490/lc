package kc;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        int[] dp = new int[triangle.size()];
        for(List<Integer> list : triangle) {
            for(int i = list.size()-1 ; i >= 0; i--){
                if(i == 0) {
                    dp[0] = dp[0] + list.get(0);
                } else if(i == list.size()-1) {
                    dp[i] = dp[i-1] + list.get(i);
                } else {
                    dp[i] = Math.min(dp[i],dp[i-1]) + list.get(i);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(Integer a : dp) {
            res = Math.min(a,res);
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		List<Integer> c = new ArrayList<Integer>();
		List<Integer> d = new ArrayList<Integer>();
		a.add(2);
		b.add(3);b.add(4);
		c.add(6);c.add(5);c.add(7);
		d.add(4);d.add(1);d.add(8);d.add(3);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(a);res.add(b);res.add(c);res.add(d);
		Triangle x = new Triangle();
		System.out.println(x.minimumTotal(res));
	}

}
