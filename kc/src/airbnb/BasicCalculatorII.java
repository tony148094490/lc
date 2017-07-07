package airbnb;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();
        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <='9') {
                String number = getNr(s, i);
                
                if(!operators.isEmpty() && operators.peek() == '*') {
                    operators.pop();
                    operands.push(operands.pop() * Integer.parseInt(number));
                } else if(!operators.isEmpty() && operators.peek() == '/') {
                    operators.pop();
                    operands.push(operands.pop() / Integer.parseInt(number));
                } else {
                    operands.push(Integer.parseInt(number));
                }
                
                i += number.length() - 1;
            } else if( s.charAt(i) != ' ') {
                operators.push(s.charAt(i));
            }
        }
        

        Stack<Integer> operandsII = new Stack<>();
        Stack<Character> operatorsII = new Stack<>();
        while(!operands.isEmpty()) operandsII.push(operands.pop());
        while(!operators.isEmpty()) operatorsII.push(operators.pop());
        
        while(!operatorsII.isEmpty()) {
            char op = operatorsII.pop();
            if(op == '+') {
                operandsII.push(operandsII.pop() + operandsII.pop());
            } else {
                operandsII.push(operandsII.pop() - operandsII.pop());
            }
        }
        return operandsII.pop();
    }
    
    private String getNr(String s, int i) {
        int j = i + 1;
        while( j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') j++;
        return s.substring(i, j);
    }
    
    
    public static void main(String[] args) {
    	BasicCalculatorII x = new BasicCalculatorII();
    	System.out.println(x.calculate("42 + 9" ));
	}
}
