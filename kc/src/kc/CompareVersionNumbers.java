package kc;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        while(i < version1.length() && j < version2.length()) {
            int ii = i;
            while(ii < version1.length() && version1.charAt(ii) != '.') ii++;
            int jj = j;
            while(jj < version2.length() && version2.charAt(jj) != '.') jj++;
            int v1 = Integer.valueOf(version1.substring(i,ii));
            int v2 = Integer.valueOf(version2.substring(j,jj));
            if(v1 < v2) {
                return -1;
            } else if(v1 > v2) {
                return 1;
            } else {
                i = ii+1;
                j = jj+1;
            }
        }
        // for cases like '1.0' v.s '1'
        while(i < version1.length() && (version1.charAt(i) == '.' || version1.charAt(i) == '0')) i++;
        while(j < version2.length() && (version2.charAt(j) == '.' || version2.charAt(j) == '0')) j++;
        
        if(i < version1.length()) return 1;
        if(j < version2.length()) return -1;
        return 0;
    }
}
