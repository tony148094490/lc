package kc;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int toKeep = num.length() - k;
        if(toKeep == num.length()) return num;

        StringBuilder sb = new StringBuilder();
        int last = -1;
        char digit = '9';
        while( toKeep > 0) {
            for(int i = last + 1 ; i <= num.length() - toKeep ; i++) {
                if(num.charAt(i) < digit) {
                    digit = num.charAt(i);
                    last = i;
                }
            }
            sb.append(digit);
            digit = '9';
            toKeep--;
        }
        int index = 0;
        while(index < sb.length() && sb.charAt(index) == '0') index++;
        if(index == sb.length()) return "0";
        return sb.substring(index);
    }
}
