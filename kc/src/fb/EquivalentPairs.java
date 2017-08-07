package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EquivalentPairs {
	public List<List<int[]>> getPairs(int[] input) {
		Map<Integer, Pair> map = new HashMap<>();
		for(int i = 0 ; i < input.length - 1; i++) {
			for(int j = i + 1; j < input.length; j++) {
				int sum = input[i] + input[j];
				map.putIfAbsent(sum , new Pair());
				Pair existingEntries = map.get(sum);
				if(!existingEntries.indexes.contains(i) && !existingEntries.indexes.contains(j)) {
					int[] newPair = {i,j};
					existingEntries.indexes.add(i);
					existingEntries.indexes.add(j);
					existingEntries.indexPairs.add(newPair);
				}
			}
		}
		
		List<List<int[]>> res = new ArrayList<>();
		for(int sum : map.keySet()) {
			Pair potential = map.get(sum);
			if(potential.indexPairs.size() < 2) continue;
			List<int[]> indexPairs = potential.indexPairs;
			for(int i = 0 ; i < indexPairs.size() - 1; i++) {
				for(int j = i + 1; j < indexPairs.size(); j++) {
					List<int[]> newRes = new ArrayList<>();
					int[] ii = indexPairs.get(i);
					int[] jj = indexPairs.get(j);
					newRes.add(new int[]{ii[0], ii[1]});
					newRes.add(new int[]{jj[0], jj[1]});
					res.add(newRes);
					}
				}
			}
		
		return res;
	}

	
	public class Pair {
		List<int[]> indexPairs;
		Set<Integer> indexes;
		public Pair() {
			indexPairs = new ArrayList<>();
			indexes = new HashSet<>();
		}
	}
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7,8,9};
		EquivalentPairs x = new EquivalentPairs();
		List<List<int[]>> res = x.getPairs(input);
		for(List<int[]> l : res) {
			for(int[] xx : l) {
				System.out.print("[" + xx[0] + "," + xx[1] + "],");
			}
			System.out.println();
		}
	}
}
