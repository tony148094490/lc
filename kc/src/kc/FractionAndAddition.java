package kc;

public class FractionAndAddition {
    public String fractionAddition(String expression) {
        if(expression.length() == 0) return "";
        String s = expression;
        
        String nr = getFirst(s);
        
        
        for(int i = nr.length() ; i < s.length(); i++) {
            String next = "";
            if(s.charAt(i) == '+') {
                next = getNext(s, i+1);
                nr = add(nr, next, true);
            } else if(s.charAt(i) == '-') {
                next = getNext(s, i+1);
                nr = add(nr, next, false);
            } else {
            	continue;
            }
                        
            i += next.length() - 1;
            
        }
        
        nr = reduce(nr);
        return nr;
    }
    
    private String reduce(String s) {
        String[] res = s.split("/");
        int up = Integer.parseInt(res[0]);
        int down = Integer.parseInt(res[1]);
        
        if((up % down) == 0) return String.valueOf(up/down) + "/1";
        
        boolean neg = false;
        if(up < 0 ) {
            neg = true;
            up = up * -1;
        }
        
        int gc = gcd(up, down);
        return neg == true ? "-" + String.valueOf(up/gc) + "/" + String.valueOf(down/gc) :
                        String.valueOf(up/gc) + "/" + String.valueOf(down/gc);
        
    }
    
    private int gcd(int a, int b) {
        int remainder = a % b;
        
        while(remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
            System.out.println(a + "," + b);
        }
        return b;
    }
    
    
    private String add(String a, String b, boolean addition) {
        String[] aa = a.split("/");
        String[] bb = b.split("/");

        int aUp = Integer.parseInt(aa[0]);
        int aDown = Integer.parseInt(aa[1]);
        int bUp = Integer.parseInt(bb[0]);
        int bDown = Integer.parseInt(bb[1]);
        
        int lcm = getLCM(aDown, bDown);
        
        if(addition) {
            int up = (lcm / aDown ) * aUp + (lcm / bDown) * bUp;
            return String.valueOf(up) + "/" + String.valueOf(lcm);
        } else {
            int up = (lcm / aDown) * aUp - (lcm / bDown) * bUp;
            return String.valueOf(up) + "/" + String.valueOf(lcm);
        }
    }
    
    private String getNext(String s, int i) {
        int j = i;
        j++;
        while(j < s.length() && s.charAt(j) != '+' && s.charAt(j) != '-') {
        	j++;
        }
        return s.substring(i, j);
    }
    
    private String getFirst(String s) {
        int i = 0;
        if(s.charAt(0) == '-') {
            i++;    
        } 
        
        while(i < s.length() && (s.charAt(i) != '+' && s.charAt(i) != '-')) {
        	i++;
        }
        
        return s.substring(0, i);
    }
    
    private int getLCM(int a, int b) {
        if(a % b == 0 ) return a;
        if(b % a == 0) return b;
        if(a < b) {
            for(int i = 2; i < b; i++) {
                if((a * i) % b == 0) return a * i;
            }
            return a * b;
        } else {
            return getLCM(b, a);
        }
    }
    
    public static void main(String[] args) {
    	FractionAndAddition x = new FractionAndAddition();
    	System.out.println(x.fractionAddition("-1/2+1/2"));
	}
}
