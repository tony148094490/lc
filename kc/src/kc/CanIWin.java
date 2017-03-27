package kc;

import java.util.HashMap;
import java.util.Map;


// choose one and see if the next will doomed to be false. 
// save the state and translate it to a memorizable thing
public class CanIWin {
    Map<Integer, Boolean> map = new HashMap<>();
    boolean[] used;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        if(desiredTotal <= maxChoosableInteger) return true;
        
        used = new boolean[maxChoosableInteger+1];
        return canWin(desiredTotal);
    }
    
    private boolean canWin(int num) {
        if(num <= 0) return false;
        int currentState = getState(used);
        if(map.containsKey(currentState)) return map.get(currentState);
        for(int i = 1; i <= used.length -1; i++) {
            if(used[i]) continue;
            used[i] = true;
            if(!canWin(num - i)) {
                map.put(currentState, true);
                used[i] = false;
                return true;
            }
            used[i] = false;
        }
        map.put(currentState, false);
        return false;
    }
    
    private int getState(boolean[] arr) {
        int res = 0;
        for(boolean x : arr) {
            res <<= 1;
            if(x == true) {
                res |= 1;
            } else {
                res |= 0;
            }
        }
        return res;
    }
}
