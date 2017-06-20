package kc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TaskWithCoolDown {
	
	// Do not need re-order
	public int taskWithCoolDown(int[] arr, int coolDown) {
		if(arr.length == 0) return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int timestamp = 0;
		for(int i = 0; i < arr.length; i++) {
			timestamp++;
			if(map.containsKey(arr[i])) {
				if(timestamp - map.get(arr[i]) > coolDown) {
					map.put(arr[i], timestamp);
				} else {
					timestamp = map.get(arr[i]) + coolDown + 1;
					map.put(arr[i], timestamp);
				}
			} else {
				map.put(arr[i], timestamp);
			}
		}
		return timestamp;
	}
	
	public String coolDown(int[] arr, int coolDown) {
		Map<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int time = 0;
		for(int x : arr) {
			if(map.containsKey(x)) {
				if(map.get(x) + coolDown < time) {
					map.put(x, time);
					sb.append(x);
					time++;
				} else {
					int newTime = map.get(x) + coolDown + 1;
					int diff = newTime - time;
					while(diff > 0) {
						sb.append("_");
						diff--;
					}
					time = newTime;
					map.put(x, time);
					sb.append(x);
					time++;
				}
			} else {
				sb.append(x);
				map.put(x, time);
				time++;
			}
			
		}
		return sb.toString();
	}
	
	public int reorderJustTime(int[] arr, int cooldown) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int x : arr) map.put(x, map.getOrDefault(x, 0) + 1);
		int maxFreq = 0;
		int nrMaxs = 0;
		for(int x : map.values()) {
			if(maxFreq < x) {
				maxFreq = x;
				nrMaxs = 1;
			} else if(maxFreq == x) {
				nrMaxs += 1;
			}
		}
		
		int interleaving = (maxFreq - 1) * (cooldown + 1) + nrMaxs;
		return Math.max(interleaving, arr.length);
	}
	
	public String reorderWithString(int[] arr, int cooldown) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int x : arr) map.put(x, map.getOrDefault(x, 0) + 1);
		StringBuilder sb = new StringBuilder();
		Comparator<Entry<Integer,Integer>> comp = (a,b) -> {return b.getValue() - a.getValue();};
		PriorityQueue<Entry<Integer,Integer>> pq = new PriorityQueue<>(comp);
		pq.addAll(map.entrySet());
		while(!pq.isEmpty()) {
			int i = 0;
			List<Entry<Integer,Integer>> list = new ArrayList<>();
			while(i <= cooldown && !pq.isEmpty()) {
				Entry<Integer,Integer> entry = pq.poll();
				sb.append(entry.getKey());
				entry.setValue(entry.getValue()-1);
				if(entry.getValue() > 0) list.add(entry);
				i++;
			}
			
			while(i <= cooldown) {
				sb.append("_");
				i++;
			}
			
			if(list.isEmpty()) return sb.toString();
			for(Entry<Integer,Integer> entry : list) {
				pq.add(entry);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		TaskWithCoolDown x = new TaskWithCoolDown();
		int[] arr = {1,2,1,1,1,1,1,1,1,1,2,3,3,4};
		System.out.println(x.coolDown(arr, 2));
		System.out.println(x.reorderWithString(arr, 2));
	}
}



