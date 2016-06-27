package kc;
public class Atoi {
	
	public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) return 0;
        
        int neg = 1;
        str = str.trim();
        if(str.charAt(0) == '+') {
            str = str.substring(1);
        } else if(str.charAt(0) == '-') {
            str = str.substring(1);
            neg = -1;
        }
         
        int res = 0;
        int newRes = res;
        int cur = 0;
        for (Character c : str.toCharArray()) {
        	if (c >= '0' && c <= '9') {
        		cur = c - '0';
        		newRes = res * 10 + cur;
        		//Two cases when checking overflows: 1) Just overflow to MIN_VALUE 2) More than MIN_VALUE
        		if (neg == 1 && (((newRes - cur)/10 != res) || (newRes < res))) {
        			return Integer.MAX_VALUE;
        		} else if(neg == -1 && (((newRes - cur) / 10) != res || (newRes < res) )) {
        			return Integer.MIN_VALUE;
        		}

        		res = res * 10 + cur;
        	} else {
        		break;
        	}
        }
        return res * neg;
	}
	
	public static void main(String[] args) {
		Atoi a = new Atoi();
		System.out.println(a.myAtoi("2147483648"));
	}
}
