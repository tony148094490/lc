package kc;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length() - 1;
        while( i < j) {
            if(num.charAt(i) == '6' && num.charAt(j) == '9') {
                i++;
                j--;
            } else if (num.charAt(i) == '0' && num.charAt(j) == '0') {
                i++;
                j--;
            } else if (num.charAt(i) == '1' && num.charAt(j) == '1') {
                i++;
                j--;
            } else if (num.charAt(i) == '8' && num.charAt(j) == '8') {
                i++;
                j--;
            } else if (num.charAt(i) == '9' && num.charAt(j) == '6') {
                i++;
                j--;
            } else {
                return false;
            }
        }
        if(i == j && num.charAt(i) != '1' && num.charAt(i) != '8' && num.charAt(i) != '0' ) {
            return false;
        }
        return true;    }
}
