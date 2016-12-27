package kc;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<String> operators = new Stack<String>();
        Stack<Integer> operands = new Stack<Integer>();
        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) == ' ') continue;
            if(s.charAt(i) == '+') {
                operators.push("+");
            } else if (s.charAt(i) == '-') {
                operators.push("-");
//            } else if (s.charAt(i) == '*') {
//                i++;
//                while(i < s.length() && s.charAt(i) == ' ') {
//                    i++;
//                }
//                String n = getNext(s, i);
//                int next = Integer.parseInt(n);
//                operands.push(operands.pop() * next);
//                i += (n.length() - 1);
//            } else if (s.charAt(i) == '/') {
//                i++;
//                while(i < s.length() && s.charAt(i) == ' ') {
//                    i++;
//                }
//                String n = getNext(s, i);
//                int next = Integer.parseInt(n);
//                operands.push(operands.pop() / next);
//                i += (n.length() - 1);
            } else if (s.charAt(i) == '(') {
                operators.push("(");
            } else if (s.charAt(i) == ')') {
                if(operators.peek().equals("(")) {
                    operators.pop();
                    continue;
                }
                Stack<Integer> tempOperands = new Stack<Integer>();
                tempOperands.push(operands.pop());
                Stack<String> tempOperators = new Stack<String>();
                while(!operators.peek().equals("(")) {
                    tempOperands.push(operands.pop());
                    tempOperators.push(operators.pop());
                }
                while(!tempOperators.isEmpty()) {
                    int first = tempOperands.pop();
                    int second = tempOperands.pop();
                    if(tempOperators.pop().equals("+")) {
                        tempOperands.push(first + second);
                    } else {
                        tempOperands.push(first - second);
                    }
                }
                operands.push(tempOperands.pop());
                operators.pop();
            } else {
                String nr = getNext(s,i);
                operands.push(Integer.parseInt(nr));
                i += (nr.length() - 1);
            }
        }
        
        if(operators.isEmpty()) return operands.pop();
        
        Stack<Integer> tempOperands = new Stack<Integer>();
        tempOperands.push(operands.pop());
        Stack<String> tempOperators = new Stack<String>();
        while(!operators.isEmpty()) {
            tempOperands.push(operands.pop());
            tempOperators.push(operators.pop());
        }
        while(!tempOperators.isEmpty()) {
            int first = tempOperands.pop();
            int second = tempOperands.pop();
            if(tempOperators.pop().equals("+")) {
                tempOperands.push(first + second);
            } else {
                tempOperands.push(first - second);
            }
        }
        return tempOperands.pop();
    }
    
    private String getNext(String s, int i) {
        int j = i;
        while(j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
            j++;
        }
        return s.substring(i,j);
    }
    
    public static void main(String[] args) {
    	BasicCalculator x = new BasicCalculator();
    	String s = "2-4-(8+2-6+(8+4-(1)+8-10))";
    	
    	System.out.print(x.calculate(s));
    }
}
