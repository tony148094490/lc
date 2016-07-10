package kc;

public class Implement_strStr {
    public int strStr(String haystack, String needle) {
        if(haystack == null && needle == null) return -1;
        if(needle == "" && haystack == "") return 0;
        
        if(haystack.length() < needle.length()) return -1;
        
        for(int i = 0 ; i < haystack.length() - needle.length() + 1 ;i++) {
            if(isInHaystack(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean isInHaystack(String h, String n, int i) {
        for(int j = i ; j < n.length() + i; j++){
            if(h.charAt(j) != n.charAt(j - i)) return false;
        }
        return true;
    }
}
