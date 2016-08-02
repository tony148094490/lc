package kc;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == ' ') continue;

            if(c < '0' || c > '9') {
                operators.push(c);
            } else {
                
                int b = 0;
                while(i< s.length() && ((s.charAt(i) <= '9' && s.charAt(i) >='0') || s.charAt(i) == ' ')){
                    if(s.charAt(i) != ' ') {
                        b = b * 10 + (int) (s.charAt(i) - '0');
                    }
                    i++;
                }
                i--;
                
                if(!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
                    int a = operands.pop();
                    char o = operators.pop();
                    if(o == '*') {
                        operands.push(a * b);
                    } else {
                        operands.push(a/b);
                    }
                } else {
                    operands.push(b);
                }
            }
        }
        
        Stack<Integer> operandsQ = new Stack<Integer>();
        while(!operands.isEmpty()) {
        	operandsQ.push(operands.pop());
        }
        
        Stack<Character> operatorsQ = new Stack<Character>();
        while(!operators.isEmpty()) {
        	operatorsQ.push(operators.pop());
        }
        
        int res = operandsQ.pop();
        while(!operatorsQ.isEmpty()) {
            char operator = operatorsQ.pop();
            int b = operandsQ.pop();
            if(operator == '+') {
                res = res + b;
            } else {
                res = res - b;
            }
            
        }
        return res;
    }
    
    public static void main(String[] args) {
    	BasicCalculatorII x = new BasicCalculatorII();
    	System.out.println(x.calculate("2 + 3 - 4" ));
	}
}
