package airbnb;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char prevSign = '+';
        int n = 0;
        for(int i = 0 ;  i < s.length(); i++ ) {
            char cur = s.charAt(i);
            if(Character.isDigit(cur)) {
                String nr = getNr(s, i);
                n = Integer.parseInt(nr);
                i += (nr.length()-1);
            } 

            if((cur != ' ' && !Character.isDigit(cur) )|| i == s.length()-1) {
                if(prevSign == '+') {
                    stack.push(n);
                } else if(prevSign == '-') {
                    stack.push(-n);
                } else if(prevSign == '*') {
                    stack.push(stack.pop() * n);
                } else {
                    stack.push(stack.pop() / n);
                }
                prevSign = cur;
                n = 0;
            }
        }
        
        int res = 0;
        while(!stack.isEmpty()) res += stack.pop();
        return res;
        
    }
    
    private String getNr(String s, int i) {
        int start = i;
        while(i < s.length() && Character.isDigit(s.charAt(i))) i++;
        return s.substring(start, i);
    }
    
    public static void main(String[] args) {
    	BasicCalculatorII x = new BasicCalculatorII();
    	System.out.println(x.calculate("42 + 9" ));
	}
}
