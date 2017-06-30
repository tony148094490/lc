package airbnb;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if(words.length == 0 || maxWidth <= 0) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        
        List<String> res = new ArrayList<>();
        List<String> curLevel = new ArrayList<>();
        int len = 0;
        for(String str : words) {
            if(str.length() > maxWidth) return new ArrayList<>();
            curLevel.add(str);
            len += str.length();
            if(len == maxWidth) {
                String local = curLevel.get(0);
                for(int i = 1; i < curLevel.size(); i++) {
                    local += " ";
                    local += curLevel.get(i);
                }
                res.add(local);
                len = 0;
                curLevel = new ArrayList<>();
            } else if(len < maxWidth) {
                len++;
            } else {
                curLevel.remove(curLevel.size()-1);
                String justified = justify(curLevel, maxWidth);
                res.add(justified);
                len = str.length() + 1;
                curLevel = new ArrayList<>();
                curLevel.add(str);
            }
        }
        
        if(!curLevel.isEmpty()) {
            String local = curLevel.get(0);
            for(int i = 1; i < curLevel.size(); i++) {
                local += " ";
                local += curLevel.get(i);
            }
            for(int j = local.length(); j < maxWidth; j++) local += " ";
            res.add(local);
        }
        return res;
    }
    
    private String justify(List<String> list, int max) {
        if(list.size() == 1) {
            String str = list.get(0);
            for(int i = str.length(); i < max; i++) {
                str += " ";
            } 
            return str;
        }
        int slots = list.size() - 1;
        int totalLen = 0;
        for(String s : list) totalLen += s.length();
        int spaces = max - totalLen;
        int baseSpacePerSlot = spaces/slots;
        int spares = spaces - baseSpacePerSlot * slots;
        
        String res = "";
        for(int i = 0 ; i < list.size() - 1; i++) {
            res += list.get(i);
            for(int j = 0 ; j < baseSpacePerSlot; j++) res += " ";
            if(spares > 0) {
                res += " ";
                spares--;
            }
        }
        res += list.get(list.size()-1);
        return res;
    }
    
 
    
    public static void main(String[] args) {
    	TextJustification x = new TextJustification();
    	String[] arr ={"This", "is", "an", "example", "of", "text", "justification."};
    	String[] arr2 ={"a", "b", "c", "d", "e", "f", "g"};
    	String[] arr3 ={"Listen","to","many,","speak","to","a","few."};
    	String[] arr4 = {"abc", "abcd", "abc"};
    	
//    	System.out.println(x.fullJustify(arr, 16));
//    	System.out.println(x.fullJustify(arr2, 1));
//    	System.out.println(x.fullJustify(arr3, 6));
    	System.out.println(x.fullJustify(arr4, 4));
    	
    	
	}
}
