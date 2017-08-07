package fb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// same as abnb city recommendation
public class Find2MutalFriend {
	// only from immediate friends, i.e 2nd connection
	public List<Integer> getTopKFriendsRecommendation(Person p, int k) {
			// several ways, pq, bucketizing. we can try both here
		// 1 use pq
		Comparator<Person> comp = (a,b) -> {return b.closeness - a.closeness;};
		PriorityQueue<Person> pq = new PriorityQueue<>(comp);
		for(Person friend : p.friends) {
			for(Person potentialRecommendation : friend.friends) {
				if(p.friends.contains(potentialRecommendation) ||
						potentialRecommendation == p) continue;
				potentialRecommendation.closeness = potentialRecommendation.closeness + 1;
				pq.remove(potentialRecommendation);
				pq.add(potentialRecommendation);
			}
		}
		
		List<Integer> pqRes = new ArrayList<>();
		while( k > 0 && !pq.isEmpty()) {
			pqRes.add(pq.poll().label);
		}
		//return pqRes;
		
		
		
		// 2 use bucket based on the fact that the highest closessness of the 
		// recommendated friend is the number of friends one has
		List<List<Person>> buckets = new ArrayList<>();
		for(int i = 0 ; i <= p.friends.size(); i++) {
			buckets.add(new ArrayList<>());
		}
		Map<Integer, Set<Person>> map = new HashMap<>();
		for(Person friend : p.friends) {
			for(Person potential : friend.friends) {
				if(potential == p || p.friends.contains(potential)) continue;
				int newCloseness = potential.closeness + 1;
				potential.closeness = newCloseness;
				map.putIfAbsent(newCloseness, new HashSet<>());
				map.get(newCloseness).add(potential);
				if(newCloseness > 1) { //remove from prev bucket
					map.get(newCloseness - 1).remove(potential);
				}
			}
		}
		for(int x : map.keySet()) {
			buckets.get(x-1).addAll(map.get(x));
		}
		
		List<Integer> res = new ArrayList<>();
		for(int i = buckets.size() - 1 ; i >= 0; i--) {
			if(buckets.get(i).isEmpty()) continue;
			for(Person pp : buckets.get(i)) {
				res.add(pp.label);
				k--;
				if(k == 0) break;
			}
		}
		return res;
	}
	
	public class Person {
		Set<Person> friends;
		int label;
		int closeness;
	}
}
