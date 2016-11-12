package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    	if(strs.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < strs.size(); i++) {
            String s = strs.get(i);
            for(int j = 0 ; j < s.length() ;j++) {
                sb.append(1);
                sb.append(s.charAt(j));
            }
            sb.append("e");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        if(s.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i+=2) {
            if(s.charAt(i) == 'e') {
                res.add(sb.toString());
                sb = new StringBuilder();
                i--;
            } else {
                sb.append(s.charAt(i+1));
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
		String[] arr = {"abced", "12312312e", "asdfxcasd"};
		List<String> list = Arrays.asList(arr);
		Codec x = new Codec();
		System.out.println(x.decode(x.encode(list)));
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));