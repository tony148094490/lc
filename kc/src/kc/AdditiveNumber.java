package kc;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for(int i = 0 ; i <= num.length() / 2; i++) {
            for(int j = i + 1 ; j <= num.length() - 1; j++) {
                if(num.charAt(0) == '0' && i > 0) return false;
                if(num.charAt(i+1) == '0' && j > i + 1) break;
                String sum = getSum(num.substring(0, i+1), num.substring(i+1, j+1));
                if(sum.length() <= num.length() - j - 1 && sum.equals(num.substring(j+1, j+1+sum.length()))) {
                    if(helper(i+1, j+1, j+1, j+1+sum.length(), num)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(int i, int j, int k, int l, String num) {
        while(l < num.length() - 1) {
            String sum = getSum(num.substring(i,j), num.substring(k,l));
            if(sum.length() <= num.length() - l && sum.equals(num.substring(l, l+sum.length()))) {
                i = k;
                j = l;
                k = l;
                l = l + sum.length();
            } else {
                return false;
            }
        }
        return true;
    }
    
    private String getSum(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i>= 0 && j >= 0) {
            int first = a.charAt(i) - '0';
            int second = b.charAt(j) - '0';
            sb.append((first+second+carry) % 10);
            carry = (first + second + carry)/10;
            i--;
            j--;
        }
        
        while(j >= 0) {
            int second = b.charAt(j) - '0';
            sb.append((second + carry) % 10);
            carry = (second + carry) / 10;
            j--;
        }
        
        while(i >= 0) {
            int second = a.charAt(i) - '0';
            sb.append((second + carry) % 10);
            carry = (second + carry) / 10;
            i--;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    
    
    public static void main(String[] args) {
    	AdditiveNumber x = new AdditiveNumber();
    	System.out.println(x.isAdditiveNumber("121474836472147483648"));
	}
    
}
