package kc;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {

        int[] dp = new int[s.length()+1];

        dp[0] = 1;

        for(int i = 1 ; i < s.length() + 1 ;i++){

            for(int j = 0 ; j < i ; j++) {

                if(dp[j] == 1 && wordDict.contains(s.substring(j,i))){

                    dp[i] = 1;

                    break;

                }

            }

        }

        return dp[s.length()] == 1;

    }
    
    
    public static void main(String[] args) {
		String word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");

		WordBreak x = new WordBreak();
		System.out.println(new Date());
		System.out.println(x.wordBreak(word, dict));
		System.out.println(new Date());

		
	}
}
