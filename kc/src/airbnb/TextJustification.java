package airbnb;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> res = new ArrayList<String>();
        for(int i = 0 ; i < words.length; i++) {
        	List<String> list = new ArrayList<String>();
        	list.add(words[i]);
        	int curLength = words[i].length();
        	i++;
        	while(curLength + (list.size() - 1) < maxWidth && i < words.length) {
        		list.add(words[i]);
        		curLength += words[i].length();
        		i++;
        	}

        	boolean lastLine = false;
        	
        	if(curLength + list.size() - 1 > maxWidth) {
        		curLength -= list.get(list.size()-1).length();
        		list.remove(list.size()-1);
        		i-=2;
        	} else if (curLength + list.size() - 1 == maxWidth) {
        		i-=1;
        	} else if(i == words.length) {
        		lastLine = true;
        	}
    		String newRes = getLevel(list, maxWidth - curLength, lastLine);
    		res.add(newRes);
        }
        return res;
    }
    
    
    private String getLevel(List<String> strs, int spaces, boolean lastLine) {
    	if(lastLine) {
    		StringBuilder sb = new StringBuilder();
    		sb.append(strs.get(0));
    		for(int i = 1; i < strs.size(); i++){
    			sb.append(" ");
    			sb.append(strs.get(i));
    		}
    		while(spaces - (strs.size() - 1) > 0) {
    			sb.append(" ");
    			spaces--;
    		}
    		return sb.toString();
    	}
    	
    	int slots = strs.size() - 1;
    	if(slots == 0) {
    		String str = strs.get(0);
    		while(spaces > 0) {
    			str += " ";
    			spaces--;
    		}
    		return str;
    	}
    	int spaceEachSlot = spaces/slots;
    	int spacesLeft = spaces - spaceEachSlot * slots;	
    	StringBuilder sb = new StringBuilder();    	
    	for(int i = 0 ; i < strs.size(); i++) {
    		sb.append(strs.get(i));
    		if(i!=strs.size()-1) {
    			for(int j = 0 ; j < spaceEachSlot;j++)sb.append(" ");
    			if(spacesLeft != 0) {
    				sb.append(" ");
    				spacesLeft--;
    			}
    		}
    	}
    	
    	return sb.toString();
    }
    
    public static void main(String[] args) {
    	TextJustification x = new TextJustification();
    	String[] arr ={"This", "is", "an", "example", "of", "text", "justification."};
    	String[] arr2 ={"a", "b", "c", "d", "e", "f", "g"};
    	String[] arr3 ={"Listen","to","many,","speak","to","a","few."};
    	
    	System.out.println(x.fullJustify(arr, 16));
    	System.out.println(x.fullJustify(arr2, 1));
    	System.out.println(x.fullJustify(arr3, 6));
    	
    	
	}
}
