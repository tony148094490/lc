package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (1) Contact group, 输入是这样的:数字是用户，字母是邮箱，有很多人有多个邮箱，找出相同的用户
  1- {x,y,z},  
  2-{x}
  3-{a,b}
  4-{y, z}
  5-{b}
  6-{m}
  7-{t,b}
这样输出就是 [1,2,4] [3,5,7], [6] 这三组。. 
 *
 */
public class ContactGroup {
	Map<Integer, Integer> parents = new HashMap<>();
	Map<String, Integer> stringToInteger = new HashMap<>();
	public List<List<Integer>> connect(Map<Integer, List<String>> map) {
		for(Integer x : map.keySet()) {
			parents.put(x, x);
			for(String y : map.get(x)) {
				if(stringToInteger.containsKey(y)) {
					int existing = stringToInteger.get(y);
					int parent = getParent(existing);
					if(parent != x) {
						parents.put(parent, x);
					}
				} else {
					stringToInteger.put(y, x);
				}
			}
		}
		
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, List<Integer>> groups = new HashMap<>();
		for(int x : parents.keySet()) {
			int parent = getParent(x);
			if(groups.containsKey(parent)) {
				groups.get(parent).add(x);
			} else {
				groups.put(parent, new ArrayList<>());
				groups.get(parent).add(x);
			}
		}
		
		for(int group : groups.keySet()) {
			res.add(groups.get(group));
		}
		return res;
	}
	
	private int getParent(int p) {
		int parent = parents.get(p);
		if(parent != p) {
			parent = getParent(parent);
			parents.put(p, parent);
		}
		return parent;
	}
	
	public static void main(String[] args) {
		Map<Integer, List<String>> map = new HashMap<>();
		List<String> first = new ArrayList<>();
		first.add("x");
		first.add("y");
		first.add("z");
		List<String> second = new ArrayList<>();
		second.add("x");
		List<String> third = new ArrayList<>();
		third.add("a");
		third.add("b");
		List<String> fourth = new ArrayList<>();
		fourth.add("y");
		fourth.add("z");
		List<String> fifth = new ArrayList<>();
		fifth.add("b");
		List<String> sixth = new ArrayList<>();
		sixth.add("m");
		List<String> seventh = new ArrayList<>();
		seventh.add("t");
		seventh.add("b");
		map.put(1, first);map.put(2, second);map.put(3, third);map.put(4, fourth);map.put(5, fifth);map.put(6, sixth);map.put(7, seventh);
		ContactGroup x = new ContactGroup();
		System.out.println(x.connect(map));
	}
}
