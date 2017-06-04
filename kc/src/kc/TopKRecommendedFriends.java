package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TopKRecommendedFriends {
	public List<Integer> getNewFriends(Person person, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(Person friend : person.friends) {
			for(Person potential : friend.friends) {
				if(person.friends.contains(potential) ||
						potential == person) continue;
				map.put(potential.id, map.getOrDefault(potential.id, 0)+1);
			}
		}
		
		int mostFrequent = person.friends.size();
		List<List<Integer>> buckets = new ArrayList<>();
		for(int i = 0 ; i <= mostFrequent; i++) {
			buckets.add(new ArrayList<>());
		}
		for(int id : map.keySet()) {
			buckets.get(map.get(id)).add(id);
		}
		List<Integer> res = new ArrayList<>();
		for(int i = buckets.size() - 1 ; i >= 0; i--) {
			for(int x : buckets.get(i)) {
				res.add(x);
				if(res.size() == k) return res;
			}
		}
		
		// less than k;
		return res;
	}
}


class Person {
	Set<Person> friends = new HashSet<>();
	int id;
	public Person(int i) {
		id = i;
	}
}