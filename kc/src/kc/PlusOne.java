package kc;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        int pointer = digits.length - 1;
        
        int carry = 1;
        int sum = 0;
        while(pointer >= 0) {
            sum = digits[pointer] + carry;
            res[pointer+1] = sum % 10;
            carry = sum / 10;
            pointer--;

        }
        res[0] = carry;

        if(res[0] == 0) return Arrays.copyOfRange(res, 1, res.length);
        return res;
    }
    
    public static void main(String[] args) {
    	PlusOne p = new PlusOne();
    	int[] arr = {9,9};
    	int[] res = p.plusOne(arr);
    	for(Integer x : res) System.out.print(x);
    }
}
