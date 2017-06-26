package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Use trie to work it out as well
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        // two parts
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        // "" and any palindromes
        for(int i = 0 ; i < words.length ; i++) {
            if(words[i].length() == 0) {
                for(int j = 0 ; j < words.length; j++) {
                    if(i == j || words[j].length() == 0) continue;
                    if(isPalin(words[j])) {
                        res.add(Arrays.asList(i,j));
                        res.add(Arrays.asList(j,i));
                    }
                }
            } else {
                map.put(words[i], i);
            }
        }
        
        // reverse a is in and b is palindrome
        for(int i = 0 ; i < words.length; i++) {
            for(int j = 0 ; j < words[i].length(); j++) {
                String first = words[i].substring(0,j);
                String second = words[i].substring(j);
                String reverseFirst = reverse(first);
                String reverseSecond = reverse(second);
                if(isPalin(first) && map.containsKey(reverseSecond) && map.get(reverseSecond) != i) res.add(Arrays.asList(map.get(reverseSecond), i));
                if(isPalin(second) && map.containsKey(reverseFirst) && map.get(reverseFirst) != i) res.add(Arrays.asList(i, map.get(reverseFirst)));
            }
        }
        return res;
    }
    
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1 ; i >=0; i--) sb.append(s.charAt(i));
        return sb.toString();
    }
    
    private boolean isPalin(String str) {
        int i = 0, j = str.length() -1;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
    	PalindromePairs x = new PalindromePairs();
    	String[] arr = {"abcd", "dcba", "lls", "s", "sssll"};
    	System.out.println(x.palindromePairs(arr));
    }
}
