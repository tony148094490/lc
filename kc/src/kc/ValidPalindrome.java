package kc;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end) {
            while(start<end && (Character.toLowerCase(s.charAt(start)) < 'a' || Character.toLowerCase(s.charAt(start)) > 'z') && (Character.toLowerCase(s.charAt(start)) < '0' || Character.toLowerCase(s.charAt(start)) > '9')) {
                start++;
            }  
            
            while(start<end && (Character.toLowerCase(s.charAt(end)) < 'a' || Character.toLowerCase(s.charAt(end)) > 'z') && (Character.toLowerCase(s.charAt(end)) < '0' || Character.toLowerCase(s.charAt(end)) > '9')) {
                end--;
            }
            
            if(start>=end) return true;
            
            Character ss = Character.toLowerCase(s.charAt(start));
            Character ee = Character.toLowerCase(s.charAt(end));
            
            if(ss != ee) return false;
            
            start++;
            end--;
            
        }
        return true;
    }
    
	public static void main(String[] args) {
		ValidPalindrome x = new ValidPalindrome();
		System.out.println(x.isPalindrome("race a car"));
	}
}
