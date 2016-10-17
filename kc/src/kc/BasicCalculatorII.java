package kc;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();
        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) == ' ') continue;
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                operators.push(s.charAt(i));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(i));
                i++;
                while(i<s.length() && (s.charAt(i)>='0' && s.charAt(i)<='9')) {
                    sb.append(s.charAt(i));
                    i++;
                }
                i--;
                if(!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
                int second = Integer.parseInt(sb.toString());
                int first = operands.pop();
                char operator = operators.pop();
                if(operator == '*') {
                    operands.push(first * second);
                } else {
                    operands.push(first / second);
                }
            } else {
                operands.push(Integer.parseInt(sb.toString()));
            }
            }
        }
        
        Stack<Integer> tempOperands = new Stack<Integer>();
        while(!operands.isEmpty()) tempOperands.push(operands.pop());
        
        Stack<Character> tempOperators = new Stack<Character>();
        while(!operators.isEmpty()) tempOperators.push(operators.pop());
        
        while(!tempOperators.isEmpty()) {
            int first = tempOperands.pop();
            int second = tempOperands.pop();
            char op = tempOperators.pop();
            if(op=='+') {
                tempOperands.push(first + second);
            } else {
                tempOperands.push(first - second);
            }
        }
        return tempOperands.pop();
    }
    
    public static void main(String[] args) {
    	BasicCalculatorII x = new BasicCalculatorII();
    	System.out.println(x.calculate("42" ));
	}
}
