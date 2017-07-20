package airbnb;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		if(words.length == 0) return res;
		List<String> cur = new ArrayList<>();
		int len = words[0].length();
		cur.add(words[0]);
		for(int i = 1; i < words.length; i++) {
			if(len + words[i].length() >= maxWidth) {
				res.add(justify1(cur, maxWidth, len));
				cur = new ArrayList<>();
				cur.add(words[i]);
				len = words[i].length(); 
			} else {
				cur.add(words[i]);
				len += (1 + words[i].length());
			}
		} 

		if(!cur.isEmpty()) {
			String last = "";
			for(String str : cur) last += " " + str;
			last = last.substring(1);
			while(last.length() < maxWidth) last += " ";
			res.add(last);
		}
		return res;
	}

	private String justify1(List<String> cur, int max, int len) {
		if(cur.size() == 1) {
			String res = cur.get(0);
			while(res.length() < max) res += " ";
			return res;
		}

		int spaces = (max - len + (cur.size() - 1));
		int avg = spaces / (cur.size()-1);
		int extra = spaces - (avg * (cur.size()-1));
		String res = "";
		for(int i = 0 ; i < cur.size()-1; i++) {
			res += cur.get(i);
			int sp = 0;
			while(sp < avg) {
				res += " ";
				sp++;
			}
			if(extra > 0) {
				res += " ";
				extra--;
			}
		}
		res += cur.get(cur.size()-1);
		return res;
	}
    
    public static void main(String[] args) {
    	TextJustification x = new TextJustification();
    	String[] arr ={"This", "is", "an", "example", "of", "text", "justification."};
    	String[] arr2 ={"a", "b", "c", "d", "e", "f", "g"};
    	String[] arr3 ={"Listen","to","many,","speak","to","a","few."};
    	String[] arr4 = {"abc", "abcd", "abc"};
    	
    	System.out.println(x.fullJustify(arr, 16));
    	System.out.println(x.fullJustify(arr2, 1));
    	System.out.println(x.fullJustify(arr3, 6));
    	System.out.println(x.fullJustify(arr4, 4));

	}
}
