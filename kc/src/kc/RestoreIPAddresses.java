package kc;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
    	List<String> res = new ArrayList<String>();
    	if(s.length() < 4) return res;
    	helper(s,0,new ArrayList<String>() ,res);
    	return res;
    }
    
    private void helper(String s, int depth, List<String> cur, List<String> res) {
    	if(s.length() == 0 && depth == 4) {
    		StringBuilder sb = new StringBuilder();
    		for(String str : cur) {
    			sb.append(str);
    			sb.append(".");
    		}
    		sb.deleteCharAt(sb.length()-1);
    		res.add(sb.toString());
    	} else if (s.length() != 0 && depth == 4) {
    		return;
    	} else if (s.length() == 0 && depth < 4) {
    		return ;
    	} else {
    		if(s.charAt(0) == '0') {
    			cur.add("0");
    			helper(s.substring(1), depth+1,cur,res);
    			cur.remove(cur.size()-1);
    		}else {
        		for(int i = 0; i < s.length() && i <= 2;i++){
        			String str = s.substring(0,i+1);
        			int x = Integer.parseInt(str);
        			if( x > 0 && x <= 255) {
        				cur.add(str);
        				helper(s.substring(i+1), depth+1, cur, res);
        				cur.remove(cur.size()-1);
        			}
        		}
    		}
    	}
    }
    
    
    public static void main(String[] args) {
    	RestoreIPAddresses x = new RestoreIPAddresses();
    	System.out.println(x.restoreIpAddresses("010010"));
	}
}
