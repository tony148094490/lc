package airbnb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

// follow up return all possible combo, use in degree and out degree to do it again
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if(words.length == 0) return "";
        if(words.length == 1) return words[0];
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        for(char c :words[0].toCharArray()) map.putIfAbsent(c, new HashSet<Character>());
        for(int i = 1; i < words.length; i++) {
            String cur = words[i];
            String last = words[i-1];
            if(cur.length() < last.length() && last.startsWith(cur)) return "";
            boolean found = false;
            for(int j = 0 ; j < cur.length(); j++) {
                map.putIfAbsent(cur.charAt(j), new HashSet<Character>());
                if(!found && j < last.length() && last.charAt(j) != cur.charAt(j)) {
                    map.get(last.charAt(j)).add(cur.charAt(j));
                    found = true;
                }
            }
        }
        
        Set<Character> overall = new HashSet<Character>();
        Stack<Character> result = new Stack<Character>();
        for(Character cur : map.keySet()) {
            if(overall.contains(cur)) continue;
            if(!dfs(map,cur,new HashSet<Character>(), overall, result)) return "";
        }
        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()) sb.append(result.pop());
        return sb.toString();
    }
    
    private boolean dfs(Map<Character, Set<Character>> map, Character cur, Set<Character> visited, Set<Character> overall, Stack<Character> result) {
        if(visited.contains(cur)) return false;
        visited.add(cur);
        for(Character c : map.get(cur)) {
            if(!dfs(map, c, visited, overall, result)) return false;
        }
        visited.remove(cur);
        if(!overall.contains(cur)) {
            result.push(cur);
            overall.add(cur);
        }
        return true;
    }
    
    private String bfs(String[] words) {
        if(words == null || words.length == 0) return "";
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Set<Character>> out = new HashMap<>();
        for(String str : words) {
            for(char c : str.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
                out.putIfAbsent(c, new HashSet<>());
            }
        }
        for(int i = 1; i < words.length; i++) {
            String last = words[i-1];
            String cur = words[i];
            int len = Math.min(last.length(), cur.length());
            for(int j = 0 ; j < len; j++) {
                if(last.charAt(j) != cur.charAt(j)) {
                    map.get(cur.charAt(j)).add(last.charAt(j));
                    out.get(last.charAt(j)).add(cur.charAt(j));
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        for(char c : map.keySet()) {
            if(map.get(c).size() == 0) q.add(c);
        }
        String res = "";
        while(!q.isEmpty()) {
            char parent = q.poll();
            for(char c : out.get(parent)) {
                map.get(c).remove(parent);
                if(map.get(c).size() == 0) q.add(c);
            }
            res += parent;
        }

        return res.length() == map.size() ? res : "";
    }
    
    
    public static void main(String[] args) {
    	AlienDictionary x = new AlienDictionary();
    	String[] arr = {  "wrt",
    			  "wrf",
    			  "er",
    			  "ett",
    			  "rftt"};
    	System.out.println(x.alienOrder(arr));
	}
}
