package kc;

public class LongestCommonPrefix {

	//Space: O(N) where N is the length of the longest string. Time: O(N * M) where N is the length of the longest string and M is the number of string in the array 
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) return "";
		StringBuilder sb = new StringBuilder();
		String str1 = strs[0];
		for(int i = 0 ; i < str1.length() ;i++){
			char c = str1.charAt(i);
			for(String str : strs) {
				if (i >= str.length() || str.charAt(i) != c) {
					return sb.toString();
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		LongestCommonPrefix p = new LongestCommonPrefix();
		String[] com = {"abc", "ab"};
		System.out.println(p.longestCommonPrefix(com));
	}

}
