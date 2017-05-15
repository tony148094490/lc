package kc;

public class ValidateIP {
    public String validIPAddress(String IP) {
        if(IP.length() <= 3 || IP.charAt(IP.length() - 1) == '.' || IP.charAt(IP.length() - 1) == ':') return "Neither";
        int i = 0;
        boolean v4 = false;
        while(i < IP.length() && IP.charAt(i) != '.' && IP.charAt(i) != ':') i++;
        if(i == IP.length()) return "Neither";
        if(IP.charAt(i) == '.') v4 = true;
        if(v4) {
            String[] strs = IP.split("\\.");
            if(strs.length != 4) return "Neither";
            for(String str : strs) {
                if(str.length() == 0 || (str.length() > 1 && str.charAt(0) == '0')) return "Neither";
                for(char c : str.toCharArray()) {
                    if(!Character.isDigit(c)) return "Neither";
                }
                if(str.length() > 3) return "Neither";
                int parse = Integer.parseInt(str);
                if(parse > 255 || parse < 0) return "Neither";
            }
            return "IPv4";
        } else {
            String[] strs = IP.split(":");
            if(strs.length != 8) return "Neither";
            for(String st : strs) {
                if(!isValid(st)) return "Neither";
            }
            return "IPv6";
        }
    }
    
    private boolean isValid(String str) {
        str = str.toLowerCase();
        if(str.length() == 0 || str.length() > 4) return false;
        for(int i = 0 ; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'f')) {
                return false;
            }
        }
        
        return true;
    }
}
