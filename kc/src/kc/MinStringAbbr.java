package kc;

import java.util.HashSet;
import java.util.Set;

public class MinStringAbbr {
    int minLen = Integer.MAX_VALUE;
    int minMask = -1;
    
    public String minAbbreviation(String target, String[] dictionary) {
        Set<Integer> set = new HashSet<>();
        int ors = 0;
        for(String s : dictionary) {
            if(s.length() != target.length()) continue;
            int candidate = 0;
            for(int i = 0 ; i < target.length(); i++) {
                if(target.charAt(i) != s.charAt(i)) candidate |= (1<<i);
            }
            set.add(candidate);
            ors |= candidate;
        }
        
        dfs(1, 0, ors, 1 << target.length(), target.length(), set);
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < target.length()) {
            if((minMask & (1<<i)) != 0) {
                sb.append(target.charAt(i));
                i++;
            } else {
                int j = i;
                while(i < target.length() && (minMask & (1<<i)) == 0) i++;
                sb.append(i-j);
            }
        }
        return sb.toString();
    }
    
    // res = number of '1' bit in mask with base of 1.
    private int getAbbrLenFromMask(int mask, int highestBit, int stringLen) {
        int res = stringLen;
        for(int curBitValue = 3; curBitValue < highestBit; curBitValue <<= 1) {
            if((curBitValue & mask) == 0) res--;
        }
        return res;
    }
    
    // mask is used to eliminate some of the strings
    private void dfs(int bitPositionToCheck, int mask, int ors, int highestBit, int stringLen, Set<Integer> dict) {
        int curLen = getAbbrLenFromMask(mask, highestBit, stringLen);
        if(curLen >= minLen) return;
        boolean match = true;
        for(int similarString : dict) {
            if((similarString & mask) == 0){
                match = false;
                break;
            }
        }
        if(match) {
            minLen = curLen;
            minMask = mask;
        } else {
            for(int cur = bitPositionToCheck; cur < highestBit; cur <<= 1) {
                if((ors & cur) != 0) dfs(cur<<1, mask | cur, ors, highestBit, stringLen, dict);
            }
        }
    }
}
