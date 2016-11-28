package kc;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    Map<String, Integer> map = new HashMap<String, Integer>();
    /** Initialize your data structure here. */
    public Logger() {
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)) {
            int lastTime = map.get(message);
            if(timestamp - lastTime < 10) return false;
            map.put(message, timestamp);
            return true;
        } else {
            map.put(message, timestamp);
            return true;
        }
    }
}
