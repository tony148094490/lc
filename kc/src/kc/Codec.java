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
    
//    // Encodes a list of strings to a single string.
//    public String encode(List<String> strs) {
//        StringBuilder sb = new StringBuilder();
//        for(String str : strs) {
//            sb.append(str.length());
//            sb.append("#");
//            sb.append(str);
//        }
//        return sb.toString();
//    }
//
//    // Decodes a single string to a list of strings.
//    public List<String> decode(String s) {
//        List<String> res = new ArrayList<>();
//        int counter = 0;
//        while(counter < s.length() -1) {
//            int i = counter+1;
//            while(s.charAt(i) != '#') i++;
//            String le = s.substring(counter, i);
//            int len = Integer.parseInt(le);
//            if(len == 0) {
//                res.add("");
//                counter += 2;
//            } else {
//                String str = s.substring(counter + le.length() + 1, counter + le.length() + 1 + len);
//                res.add(str);
//                counter += le.length() + len + 1;
//            }
//        }
//        return res;
//    }
    
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