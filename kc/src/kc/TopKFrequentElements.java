package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer s : nums) {
        	map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<Integer>[] count = new List[nums.length + 1];
        for(Integer key : map.keySet()) {
        	int frequency = map.get(key);
        	if(count[frequency] == null) count[frequency] = new ArrayList<Integer>();
        	count[frequency].add(key);
        }
        
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i = count.length - 1 ; i >= 0 && res.size() < k; i--) {
        	if(count[i] != null) {
        		res.addAll(count[i]);
        	}
        }
        return res;
        
    }
}
