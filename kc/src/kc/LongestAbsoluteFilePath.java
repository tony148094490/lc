package kc;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Stack<String> stack = new Stack<String>();
        int tabs = 0;
        int level = 0;
        int len = 0;
        int curIndex = 0;
        String topDir = getString(input, 0);
        if(isFile(topDir)) return topDir.length();
        stack.push(topDir);
        int potentialLen = topDir.length();
        curIndex = topDir.length();
        while(curIndex < input.length()) {
                tabs = getTabs(input, curIndex+1);
                String str = getString(input, curIndex + 1 + tabs);
                if(tabs != level + 1) {
                     while(level >= tabs) {
                        String toPop = stack.pop();
                        level--;
                        potentialLen -= (1 + toPop.length());
                     }
                }
                level++;
                stack.push(str);
                potentialLen += (1+ str.length());
                if(isFile(str) && len < potentialLen) {
                    len = potentialLen;
                }
                curIndex += (1 +  tabs + str.length()) ;
        }
        return len;
    }
    
    private String getString(String s, int start) {
        int right = start + 1;
        while(right < s.length() && s.charAt(right) != '\n') {
            right++;
        }
        return s.substring(start, right);
    }
    
    private int getTabs(String s, int start) {
        int res = 0;
        while(s.charAt(start) == '\t') {
            res++;
            start += 1;
        }
        return res;
    }
    
    private boolean isFile(String s) {
        for(char c : s.toCharArray()) {
            if(c == '.') return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
//    	LongestAbsoluteFilePath x = new LongestAbsoluteFilePath();
//    	String a = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
//    	String b = "dir\n\ta.text";
//    	System.out.println(x.lengthLongestPath(a));
//    	System.out.println(x.lengthLongestPath(b));
//    	
		System.out.println((char) ('a' + 3));
	}
}
