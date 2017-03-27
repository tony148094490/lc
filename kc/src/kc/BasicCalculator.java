package kc;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                String nr = getNumber(s, i);
                res += sign * Integer.parseInt(nr);
                i += nr.length() - 1;
            } else if(s.charAt(i) == '-') {
                sign = -1;
            } else if(s.charAt(i) == '+') {
                sign = 1;
            } else if(s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if(s.charAt(i) == ')') {
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }
    
    private String getNumber(String s, int j) {
        int i = j;
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') i++;
        return s.substring(j, i);
    }
    
    public static void main(String[] args) {
    	BasicCalculator x = new BasicCalculator();
    	String s = "2-4-(8+2-6+(8+4-(1)+8-10))";
    	
    	System.out.print(x.calculate(s));
    }
}
