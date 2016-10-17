package kc;

import java.util.ArrayList;
import java.util.List;
/**
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 *
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(num,target,0,res,"",0,0);
        return res;
    }
    
    private void helper(String num, int target, int index, List<String> list, String path, long eval, long multiply) {
    	if(index == num.length() && eval == target) {
    		list.add(path);
    		return;
    	}
    	
    	for(int i = index; i < num.length(); i++) {
    		if(i != index && num.charAt(index) == '0') {
    			break;
    		}
    		long number = Long.parseLong(num.substring(index, i+1));
    		if(index == 0) {
    			helper(num, target, i + 1, list, path + number, number, number);
    		} else {
    			helper(num,target,i+1,list,path + "+" + number, eval + number, number);
    			helper(num,target,i+1,list,path + "-" + number, eval - number, -number);
    			helper(num,target,i+1,list,path + "*" + number, eval - multiply + multiply * number, multiply * number);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	ExpressionAddOperators x = new ExpressionAddOperators();
    	System.out.println(x.addOperators("105", 5));
    }
}
