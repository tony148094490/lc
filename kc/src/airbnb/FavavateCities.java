package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
  Coding:给了一堆用户，每个用户有一堆想去的城市(用整数表示的)，这些城市是按照用户的喜好程度排序的，
  比如
    Mary:10, 2, 5, 20
    John: 3, 10, 5, 18
    Peter: 4, 3, 8
    Kate: 3, 7, 18, 1
    要求输出所有的城市，并且保持每个用户喜欢的顺序。其实就是topological sort.
 */
public class FavavateCities {
	public List<Integer> get(List<List<Integer>> lists) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for(List<Integer> list : lists) {
			for(int i = 0 ; i < list.size() - 1; i++) {
				map.putIfAbsent(list.get(i), new HashSet<>());
				map.putIfAbsent(list.get(i+1), new HashSet<>());
				map.get(list.get(i)).add(list.get(i+1));
			}
		}

		Set<Integer> overall = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		for(int i : map.keySet()) {
			if(overall.contains(i)) continue;
			if(!dfs(map,i,new HashSet<>(), stack, overall)) return new ArrayList<>();
		}
		
		List<Integer> res = new ArrayList<>();
		while(!stack.isEmpty()) res.add(stack.pop());
		return res;
	}

	private boolean dfs(Map<Integer, Set<Integer>> map, int cur, Set<Integer> visited, Stack<Integer> stack, Set<Integer> overall) {
		if(visited.contains(cur)) return false;
		visited.add(cur);
		for(Integer x : map.get(cur)) {
			if(!dfs(map, x, visited, stack, overall)) {
				visited.remove(cur);
				return false;
			}
		}
		visited.remove(cur);
		if(!overall.contains(cur)) {
			stack.push(cur);
			overall.add(cur);
		}
		return true;
	}

	
	public static void main(String[] args) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> a = Arrays.asList(10,2,5,20);
		List<Integer> b = Arrays.asList(3,10,5,20);
		List<Integer> c = Arrays.asList(4,3,8);
		List<Integer> d = Arrays.asList(3,7,18,1);
		res.add(a);res.add(b);res.add(c);res.add(d);
		FavavateCities x = new FavavateCities();
		System.out.println(x.get(res));
	}
}
