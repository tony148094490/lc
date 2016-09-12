package kc;


public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
            if(s1.length() == 0) return s2.length() == 0;
            if(s1.length() != s2.length()) return false;
            if(s1.equals(s2)) return true;
            
            int[] checkAna = new int[26];
            for(int i = 0 ; i < s1.length(); i++) {
                checkAna[s1.charAt(i) - 'a']++;
                checkAna[s2.charAt(i) - 'a']--;
            }
            for(Integer x : checkAna) {
                if(x != 0) return false;
            }
            
            for(int i = 1; i < s1.length(); i++) {
                if(isScramble(s1.substring(0, i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
                if(isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) return true;
            }
            return false;
        }
    
    public static void main(String[] args) {
		String s1 = "abab";
		String s2 = "aabb";
		ScrambleString x = new ScrambleString();
		System.out.println(x.isScramble(s1, s2));
	}
}
