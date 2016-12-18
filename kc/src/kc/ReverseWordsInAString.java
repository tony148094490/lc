package kc;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("//s+");
        String res = "";
        for(int i = arr.length - 1 ; i > 0; i--) {
        	res += arr[i] + " ";
        }
        return res += arr[0];
    }
    
    public String reverseWords2(String s) {
    	String r = reverse(s);
    	StringBuilder sb =  new StringBuilder();
    	for(int i = 0 ; i < r.length(); i++) {
    		if(r.charAt(i) == ' ') {
    			while(i < r.length() && r.charAt(i) == ' ' ) {
    				i++;
    			}
    		}
    		
    		if(i < r.length()){
    			int j = i;
    			while(j < r.length() && r.charAt(j) != ' ') {
    				j++;
    			}
    			sb.append(reverse(r.substring(i,j)));
    			sb.append(" ");
    			i = j;
    		}
    	}
    	if(sb.length() == 0) return sb.toString();
    	return sb.deleteCharAt(sb.length()-1).toString();
    }
    
    private String reverse(String s) {
    	char[] arr = s.toCharArray();
    	for(int i = 0 ; i < arr.length/2;i++){
    		char temp = arr[i];
    		arr[i] = arr[arr.length - 1 - i];
    		arr[arr.length-1-i] = temp;
    	}
    	return new String(arr);
    }
    
    public static void main(String[] args) {
		String a = "   a monkey is a king  ";
		ReverseWordsInAString x = new ReverseWordsInAString();
		System.out.println(x.reverseWords2(a));
	}
}
