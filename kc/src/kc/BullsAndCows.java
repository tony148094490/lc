package kc;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
		Map<Character, Integer> secretMap = new HashMap<Character, Integer>();
		for(int i = 0 ; i < secret.length(); i++) {
			char x = secret.charAt(i);
			if(x == guess.charAt(i)) continue;
			if (secretMap.containsKey(x)) {
				secretMap.put(x, secretMap.get(x) + 1);
			} else {
				secretMap.put(x, 1);
			}
		}
		
		int bull = 0;
		int cow = 0;
		for(int i = 0 ; i < guess.length(); i++) {
			char curChar = guess.charAt(i);
			if(curChar == secret.charAt(i)) {
				bull++;
			}
			else if(secretMap.containsKey(curChar)) {
				cow++;
				int cur = secretMap.get(curChar);
				cur = cur - 1;
				if(cur == 0) {
					secretMap.remove(curChar);
				} else {
					secretMap.put(curChar, cur);
				}
			}
		}
		return bull + "A" + cow + "B";
    }
    
    public static void main(String[] args) {
    	BullsAndCows x = new BullsAndCows();
    	System.out.println(x.getHint("1122", "1222"));
	}
}
