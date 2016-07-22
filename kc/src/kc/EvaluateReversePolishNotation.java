package kc;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        if(tokens.length < 3) return Integer.parseInt(tokens[0]);
        
        Stack<Integer> numbers = new Stack<Integer>();
        numbers.push(Integer.parseInt(tokens[0]));
        numbers.push(Integer.parseInt(tokens[1]));
    	int a = 0;
    	int b = 0;
    	int res = 0;
    	
        for(String str : tokens) {

        	switch(str) {
        	case "*":
        			a = numbers.pop();
        			b = numbers.pop();
        			res = a * b;
        			break;
        	case "+":
        			a = numbers.pop();
        			b = numbers.pop();
        			res = a + b;
        			break;
        	case "-":
        			a = numbers.pop();
        			b = numbers.pop();
        			res = b - a;
        			break;
        	case "/":
        			a = numbers.pop();
        			b = numbers.pop();
        			res = b / a;
        			break;
        	default:
        		res = Integer.parseInt(str);
        	}
        	numbers.push(res);
        }
        return numbers.pop();
    }
    
    public static void main(String[] args) {
    	EvaluateReversePolishNotation x = new EvaluateReversePolishNotation();
    	String[] arr = {"4", "13", "5", "/", "+"};
    	System.out.println(x.evalRPN(arr));
	}
}
