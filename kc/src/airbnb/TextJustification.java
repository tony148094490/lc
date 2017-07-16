package airbnb;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(maxWidth == 0) {
            res.add("");
            return res;
        }
        List<String> cur = new ArrayList<>();
        cur.add(words[0]);
        int len = words[0].length();
        for(int i = 1; i < words.length; i++) {
            if(len + words[i].length() >= maxWidth) {
                res.add(justify(cur, maxWidth - (len - cur.size()+1)));
                cur = new ArrayList<>();
                cur.add(words[i]);
                len = words[i].length();

            } else {
                cur.add(words[i]);
                len += 1;
                len += words[i].length();
            }
        }
        
        if(cur.size() > 0) {
            String last = "";
            for(String str : cur) {
                last += str;
                last += " ";
            }
            last = last.substring(0, last.length()-1);
            while(last.length() < maxWidth) {
                last += " ";
            }
            res.add(last);
        }
        return res;
    }
    
    private String justify(List<String> list, int spaces) {
        if(list.size() == 0) return "";
        if(list.size() == 1) {
            String res = list.get(0);
            while(spaces > 0) {
                res += " ";
                spaces--;
            }
            return res;
        }
        System.out.println(spaces);
        int avg = spaces / (list.size() - 1);
        int additional = spaces - (avg * (list.size()-1));
        
        String res = "";
        for(int i = 0 ; i < list.size() - 1; i++) {
            res += list.get(i);
            int inbetween = 0;
            while(inbetween < avg) {
                res += " ";
                inbetween++;
            }
            if(additional > 0) {
                res += " ";
                additional--;
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
