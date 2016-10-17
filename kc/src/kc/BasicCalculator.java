package kc;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<String> operands = new Stack<String>();
        Stack<String> operators = new Stack<String>();
        Set<String> operatorSet = new HashSet<String>();
        operatorSet.add("+");
        operatorSet.add("-");
        
    	for(int i = 0 ; i < s.length(); i++) {
        	if(s.charAt(i) == ' ') continue;
        	StringBuilder sb = new StringBuilder();
        	if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(' || s.charAt(i) ==')') {
        		sb.append(s.charAt(i));
        	} else {
        		sb.append(s.charAt(i));
        		i++;
        		while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        			sb.append(s.charAt(i));
        			i++;
        		}
        		i--;
        	}
        	
        	if(operatorSet.contains(sb.toString())) {
        		operators.push(sb.toString());
        	} else if(sb.toString().equals(")")){
        		String temp = operands.pop();
        		if(operands.peek().equals("(")) {
        			operands.pop();
        			operands.push(temp);
        			continue;
        		}
        		operands.push(temp);
        		Stack<String> tempOperands = new Stack<String>();
        		Stack<String> tempOperators = new Stack<String>();
        		while(!operands.peek().equals("(")) {
        			tempOperands.push(operands.pop());
        			if(operands.peek().equals("(")) break;
        			tempOperators.push(operators.pop());
        		}
        		operands.pop();
        		while(!tempOperators.isEmpty()) {
        			Integer a = Integer.parseInt(tempOperands.pop());
        			Integer b = Integer.parseInt(tempOperands.pop());
        			String opr = tempOperators.pop();
        			if(opr.equals("+")) {
        				Integer res = a + b;
        				tempOperands.push(res.toString());
        			} else {
        				Integer res = a - b;
        				tempOperands.push(res.toString());
        			}
        		}
        		operands.push(tempOperands.pop());
        	} else {
        		operands.push(sb.toString());
        	}        	
        }
    	
    	if(operators.isEmpty()) return Integer.parseInt(operands.pop());
    	
    	Stack<String> tempOperands = new Stack<String>();
		Stack<String> tempOperators = new Stack<String>();
		while(!operators.isEmpty()) {
			tempOperators.push(operators.pop());
			if(!operands.isEmpty() && !operands.peek().equals("("))
			tempOperands.push(operands.pop());
			if(!operands.isEmpty() && !operands.peek().equals("("))
			tempOperands.push(operands.pop());
		}
		
		while(!tempOperators.isEmpty()) {
			Integer a = Integer.parseInt(tempOperands.pop());
			Integer b = Integer.parseInt(tempOperands.pop());
			String opr = tempOperators.pop();
			if(opr.equals("+")) {
				Integer res = a + b;
				tempOperands.push(res.toString());
			} else {
				Integer res = a - b;
				tempOperands.push(res.toString());
			}
		}
		return Integer.parseInt(tempOperands.pop());
    }
    
    public static void main(String[] args) {
    	BasicCalculator x = new BasicCalculator();
    	String s = "2-4-(8+2-6+(8+4-(1)+8-10))";
    	
    	System.out.print(x.calculate(s));
    }
}
