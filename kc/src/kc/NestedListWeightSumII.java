package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedListWeightSumII {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int max = 1;
	public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList.size() == 0) return 0;
        for(NestedInteger root : nestedList) {
        	dfs(root, 1);
        }
        int level = 1;
        int res = 0;
        

        while(max > 0) {
            if(map.containsKey(max))
        	res += map.get(max) * level;
        	max--;
        	level++;
        }
        return res;
    }
	
	private void dfs(NestedInteger root, int level) {
		if(root.isInteger()) {
			max = Math.max(level, max);
			if(map.containsKey(level)) {
				map.put(level, map.get(level) + root.getInteger());
			} else {
				map.put(level, root.getInteger());
			}
		} else {
			List<NestedInteger> list = root.getList();
			for(NestedInteger child: list) {
				dfs(child, level+1);
			}
		}
	}
	
    public int depthSumInverse2(List<NestedInteger> nestedList) {
        int max = getMax(nestedList);
        return getNr(max, nestedList);
    }
    
    private int getMax(List<NestedInteger> list) {
        int res = 1;
        for(NestedInteger x : list) {
            if(x.isInteger()) continue;
            res = Math.max(res, getMax(x.getList()) + 1);
        }
        return res;
    }
    
    private int getNr(int max, List<NestedInteger> list) {
        int res = 0;
        int next = 0;
        for(NestedInteger x : list) {
            if(x.isInteger()) {
                res += x.getInteger();
            } else {
                next += getNr(max - 1, x.getList());
            }
        }
        res = res * max;
        return res + next;
    }
	
	
	public static void main(String[] args) {
		NestedInteger a = new NestedInteger();
		a.setInteger(0);
		NestedInteger b = new NestedInteger();
		b.setInteger(0);
		NestedInteger e = new NestedInteger();
		e.setInteger(0);
		NestedInteger c = new NestedInteger();
		c.setInteger(0);
		NestedInteger d = new NestedInteger();
		d.setInteger(0);

		List<NestedInteger> list = new ArrayList<NestedInteger>();
		list.add(a);list.add(b);list.add(c);list.add(d);list.add(e);
		
		
		NestedListWeightSumII x = new NestedListWeightSumII();
		System.out.println(list);
		System.out.println(x.depthSumInverse(list));
	}
}
