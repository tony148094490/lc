package fb;

public class MinWordSubstring {
	public String minWindow(String s, String t) {
		int[] ref = new int[256];
		for(char c : t.toCharArray()) {
			ref[c]++;
		}
		int from = 0;
		int min = Integer.MAX_VALUE;
		int res = 0;
		int len = t.length();
		for(int i = 0 ; i < s.length(); i++) {
			char cur = s.charAt(i);
			ref[cur]--;
			if(ref[cur] >= 0) {
				len--;
			}
			
			while(len == 0) {
				if(i - from + 1 < min) {
					min = i - from + 1;
					res = from;
				}
				ref[s.charAt(from)]++;
				if(ref[s.charAt(from)] == 1) {
					len++;
				}
				from++;
			}
		}
		
		if(min == Integer.MIN_VALUE) return "";
		return s.substring(res, min + res);
		
	}
	
	public static void main(String[] args) {
		MinWordSubstring x = new MinWordSubstring();
		System.out.println(x.minWindow("abcdefg", "cdg"));
	}
}
