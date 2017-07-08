package airbnb;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        char sign = '+';
        for(int i = 0 ; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                number = number * 10 + (s.charAt(i) - '0');
            }
            
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length()-1) {
                if(sign  == '+') {
                    stack.push(number);
                } else if(sign == '-') {
                    stack.push(-number);
                } else if(sign == '*') {
                    stack.push(stack.pop() * number);
                } else {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = s.charAt(i);
            }
        }
        int res = 0;
        while(!stack.isEmpty()) res += stack.pop();
        return res;
    }
    
    public static void main(String[] args) {
    	BasicCalculatorII x = new BasicCalculatorII();
    	System.out.println(x.calculate("42 + 9" ));
	}
}
