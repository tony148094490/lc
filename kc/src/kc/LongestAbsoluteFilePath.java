package kc;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Stack<String> dir = new Stack<String>();
        int res = 0;
        int i = 0;
        while(i < input.length() && input.charAt(i) != '\n') i++;
        String root = input.substring(0, i);
        dir.push(root);
        res += root.length();
        int max = 0;
        int parentTabs = 0;
        if(isFile(root)) max = res;
        i++;
        for(; i < input.length(); i++) {
        	int currentTabs = 0;
        	while(i < input.length() && input.charAt(i) == '\t') {
        		i++;
        		currentTabs++;
        	}
        	int j = i;
        	while(j < input.length() && input.charAt(j) != '\n') j++;
        	String curString = input.substring(i,j);
        	if(currentTabs > parentTabs) {
        		dir.push(curString);
        		parentTabs = currentTabs;
        		res+= (curString.length() + 1);
        	} else {
        		while(parentTabs >= currentTabs) {
        			String parent = dir.pop();
        			parentTabs--;
        			res -= (parent.length() + 1);
        		}
        		parentTabs = currentTabs;
        		dir.push(curString);
        		res += (curString.length() + 1);
        	}
        	
    		if(isFile(curString)) {
    			max = Math.max(max, res);
    		}
        	i = j;
        }

        return max;
    }
    
    private boolean isFile(String file) {
    	for(int i = 0; i < file.length() ;i++) {
    		if(file.charAt(i) == '.') return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	LongestAbsoluteFilePath x = new LongestAbsoluteFilePath();
    	String a = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
    	String b = "dir\n\ta.text";
    	System.out.println(x.lengthLongestPath(a));
    	System.out.println(x.lengthLongestPath(b));
    	
		
	}
}
