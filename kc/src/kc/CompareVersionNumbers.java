package kc;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null) return 2;
        version1 = version1.trim();
        version2 = version2.trim();
        
        if(version1.length() == 0 && version2.length() == 0) {
            return 0;
        } else if (version1.length() == 0) {
            return -1;
        } else if (version2.length() == 0) {
            return 1;
        }
        
        int i = 0;
        int ii = 0;
        
        int j = 0;
        int jj = 0;
        int a = 0;
        int b = 0;
        
        while(i < version1.length()  && j < version2.length()) {
            while(ii < version1.length() && version1.charAt(ii) != '.') {
                ii++;
            }
            
            if(i == ii){
                i++;
                ii++;
                continue;
            }
            
            a = Integer.parseInt(version1.substring(i,ii));
            
            while(jj < version2.length() && version2.charAt(jj) != '.') {
                jj++;
            }
            if(j == jj){
                j++;
                jj++;
                continue;
            }
            
            b = Integer.parseInt(version2.substring(j,jj));
            
            if(a < b) return -1;
            if(a > b) return 1;
            
            ii++;
            jj++;
            i = ii;
            j = jj;
        }
        
    
        
        if(i < version1.length()) {
            while(ii < version1.length() && (version1.charAt(ii) == '.'  || version1.charAt(ii) == '0')) {
                 ii++;
            }
            if(ii < version1.length()) return 1;
        }
        
        if(j < version2.length()) {
            while(jj < version2.length() && (version2.charAt(jj) == '.'  || version2.charAt(jj) == '0')) {
                 jj++;
            }
            if(jj < version2.length()) return -1;
        }
        
        return 0;
    }
}
