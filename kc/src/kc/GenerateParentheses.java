package kc;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
    	List<String> res = new ArrayList<String>();
    	generateParenthesisHelper(n,n,res,"");
    	return res;
    }
    
    private void generateParenthesisHelper(int left, int right, List<String> res, String cur) {
    	if(left == 0 && right == 0) {
    		res.add(cur);
    		return;
    	}
    	
    	if (left > 0) {
    		left--;
    		generateParenthesisHelper(left, right, res, cur+'(');
    		left++;
    	}
    	
    	if (left < right && right > 0) {
    		right--;
    		generateParenthesisHelper(left, right, res, cur+')');
    	}
    	
    }
	
	public static void main(String[] args) {
		GenerateParentheses x = new GenerateParentheses();
		System.out.println(x.generateParenthesis(3));
	}
}
