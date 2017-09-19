package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PaintHouse {
	public int paint(int[] cost, HashMap<Integer, List<Integer>> houses) {
		List<Set<Integer>> groups = new ArrayList<>();
		Set<Integer> group = new HashSet<>();
		for(int h : houses.keySet()) {
			group.add(h);
		}
		while (group.size() > 0) {
			Set<Integer> next = new HashSet<>();
			Iterator<Integer> it = group.iterator();
			while(it.hasNext()) {
				int potentialCurrentRound = it.next();
				if(next.contains(potentialCurrentRound)) {
					it.remove();
					continue;
				}
				
				for(int n : houses.get(potentialCurrentRound)) {
					if(!group.contains(n)) continue;// only consider remaining
					next.add(n);
				}
			}

			groups.add(new HashSet<>(group));
			group = next;
		}
		
		Comparator<Set<Integer>> comp = (a,b) -> {return b.size() - a.size();};
		int totalCost = 0;
		int index = 0;
		Arrays.sort(cost);
		Collections.sort(groups, comp);
		for (Set<Integer> set : groups) {
			totalCost += set.size() * cost[index];
			index++;
		}
		return totalCost;
	}
}
