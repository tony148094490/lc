package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        };
        
        Arrays.sort(words, comp);
        
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for(String word : words) {
            if(canForm(word, dict)) {
                res.add(word);
            }
            dict.add(word);
        }
        return res;
    }
    
    private boolean canForm(String word, Set<String> set) {
        if(set.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for(int i = 1 ; i <= word.length(); i++) {
            for(int j = 0 ; j < i ; j++) {
                if(dp[j] && set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
