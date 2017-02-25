package kc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;


public class RearrangeStringKDistanceApart {
    public String rearrangeString(String str, int k) {
    	if(str.length() == 0) return "";
    	if(k == 0) return str;
    	int[] nr = new int[26];
    	Map<Integer, Set<Character>> map = new HashMap<Integer, Set<Character>>();
    	Set<Character> set = new HashSet<Character>();
    	map.put(1, set);
    	int max = 0;
    	for(char c : str.toCharArray()) { 	
    		nr[c - 'a']++;
    		if(map.containsKey(nr[c-'a'])) {
    			map.get(nr[c-'a']).add(c);
    		} else {
    			Set<Character> newSet = new HashSet<Character>();
    			newSet.add(c);
    			map.put(nr[c-'a'], newSet);
    		}
    		max = Math.max(max, nr[c-'a']);
    		if(nr[c-'a'] > 1)
			map.get(nr[c-'a'] - 1).remove(c);
    	}
    	
    	Comparator<Integer> comp = new Comparator<Integer>(){
    		@Override
    		public int compare(Integer x, Integer y) {
    			return y.compareTo(x);
    		}
    	};
    	
    	PriorityQueue<Integer> occurrences = new PriorityQueue<Integer>(comp);
    	for(int x : map.keySet()) occurrences.add(x);
    	StringBuilder sb = new StringBuilder();
		
    	
    	while(sb.length() < str.length()) {
        	int counter = k;
    		Map<Integer, Set<Character>> toAddedBack = new HashMap<Integer, Set<Character>>();
    		while(counter > 0) {
    			if(occurrences.isEmpty()) {
    				if(sb.length() == str.length()) return sb.toString();
    				return "";
    			}
    			int highest = occurrences.peek();
        		Set<Character> highSet = map.get(highest);
        		
        		if(highSet.size() == 0) {
        			occurrences.poll();
        			continue;
        		}
        		for(Character c : highSet) {
        			sb.append(c);
        			if(toAddedBack.containsKey(highest - 1)) {
        				toAddedBack.get(highest - 1).add(c);
        			} else {
        				Set<Character> s = new HashSet<Character>();
        				s.add(c);
        				toAddedBack.put(highest - 1, s);
        			}
        			counter--;
        			if(counter == 0) {
        				break;
        			}
        		}
        		if(counter != 0) {
        			occurrences.poll();
        		}
    		}
    		for(Entry<Integer, Set<Character>> entry : toAddedBack.entrySet()) {	
    			int occurrence = entry.getKey();
    			map.get(occurrence+1).removeAll(entry.getValue());
    			if(occurrences.peek() < occurrence) {
    				occurrences.add(occurrence);
    			}
    			if(occurrence == 0) continue;
    			if(map.containsKey(occurrence)) {
    				map.get(occurrence).addAll(entry.getValue());
    			} else {
    				map.put(occurrence, entry.getValue());
    			}
    		}    		
    	}
    	
    	return sb.toString();
    }
    
    public String rearrangeString2(String s, int k) {
        if(s.length() == 0 ) return "";
        if(k == 0) return s;
        int[] freq = new int[26];
        for(char c: s.toCharArray()) {
            freq[c-'a']++;
        }
        Map<Integer, Set<Character>> map = new HashMap<>();
        for(int i = 0 ; i < 26; i++) {
            if(freq[i] == 0) continue;
            if(map.containsKey(freq[i])) {
                map.get(freq[i]).add((char) ('a' + i));
            } else {
                Set<Character> set = new HashSet<>();
                set.add((char) ('a' + i));
                map.put(freq[i], set);
            }
        }
        
        Comparator<Integer> comp = new Comparator<Integer>(){
          @Override
          public int compare(Integer a, Integer b) {
              return b.compareTo(a);
          }
        };
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(comp);
        Set<Integer> nr = new HashSet<>();
        for(int x : map.keySet()) {
            maxHeap.add(x);
            nr.add(x);
        }

        StringBuilder sb = new StringBuilder();
        while(!map.isEmpty()) {
            System.out.println(map);
            System.out.println(maxHeap);
            
            int counter = k;
            Map<Integer, Set<Character>> toAddBack = new HashMap<>();
            while(counter > 0) {
                if(maxHeap.isEmpty()) {
                    if(sb.length() == s.length()) return sb.toString();
                    return "";
                }
                
                int nextHighest = maxHeap.poll();
                nr.remove(nextHighest);
                
                Set<Character> highset = map.get(nextHighest);
                if(highset == null) {
                    continue;
                }

                for(char c : highset) {
                    sb.append(c);
                    
                    if(!toAddBack.containsKey(nextHighest)) {
                        Set<Character> set = new HashSet<>();
                        set.add(c);
                        toAddBack.put(nextHighest, set);
                    } else {
                        toAddBack.get(nextHighest).add(c);
                    }
            
                    counter--;
                    if(counter == 0){
                      nr.add(nextHighest);
                      maxHeap.add(nextHighest);
                      break;
                    } 
                }

            }
            

            // update
            for(int x : toAddBack.keySet()) {
                if(!nr.contains(x - 1)) {
                    maxHeap.add(x-1);
                    nr.add(x-1);
                }
                
                Set<Character> cc = toAddBack.get(x);
                Set<Character> orig = map.get(x);
                for(char c : cc) {
                    orig.remove(c);
                    if(x > 1) {
                        if(map.containsKey(x-1)) {
                            map.get(x-1).add(c);
                        } else {
                            Set<Character> newSet = new HashSet<>();
                            newSet.add(c);
                            map.put(x-1, newSet);
                        }
                    }
                }
                if(orig.size() ==0) map.remove(x);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
		String str = "aaabc";
//		RearrangeStringKDistanceApart x = new RearrangeStringKDistanceApart();
//		System.out.println(x.rearrangeString(str, 2));
		System.out.println((char) ('a' + 1));
	}
}
