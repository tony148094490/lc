package kc;

public class ValidateIP {
    public String validIPAddress(String IP) {
        String[] ipv4 = IP.split("\\.");
        String[] ipv6 = IP.split(":");

        if(ipv4.length == 4) {
            if(IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.') return "Neither";
            boolean res = validateIPV4(ipv4);
            if(res) return "IPv4";
            return "Neither";
        } else if(ipv6.length == 8) {
            if(IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':') return "Neither";
            boolean res = validateIPV6(ipv6);
            if(res) return "IPv6";
            return "Neither";
        } else {
            return "Neither";
        }
    }
    
    private boolean validateIPV4(String[] strs) {
        for(String str : strs) {
            if(str.isEmpty()) return false;
            if(str.charAt(0) == '0' && str.length() > 1 || str.length() > 3) return false;
            for(char c : str.toCharArray()) {
                if(c >= '0' && c <= '9') continue;
                return false;
            }
            if(Integer.parseInt(str) >= 0 && Integer.parseInt(str) <= 255) continue;
            return false;
        }
        return true;
    }
    
    private boolean validateIPV6(String[] strs) {
        for(String str : strs) {
            if(str.isEmpty()) return false;
            if(str.length() > 4) return false;
            for(int i = 0 ; i < str.length(); i++) {
                if(str.charAt(i) >= '0' && str.charAt(i) <='9') continue;
                if(str.charAt(i) >= 'a' && str.charAt(i) <= 'f') continue;
                if(str.charAt(i) >= 'A' && str.charAt(i) <= 'F') continue;
                return false;
            }
        }
        return true;
    }
}
