package kc;

public class LongestPalindrome {

	// Time O(n^2) = n * (n), Space O(1)
	public String longestPalindromeBad(String s) {
		if (s == null)
			return null;

		String res = null;
		int l = -1 ;
		int r = -1 ;
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			l = i;
			r = i;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				if (right - left + 1 < r - l + 1) {
					right = r;
					left = l;
				}
				l--;
				r++;
				
			}

			l = i;
			r = i + 1;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				if (right - left + 1 < r - l + 1) {
					right = r;
					left = l;
				}
				l--;
				r++;
				
			}

		}
		res = s.substring(left, right + 1);
		return res;
	}
	
	// Time O(n^2 + n^2) , Space O(n^2)
	public String longestPalindrome(String s) {
		if (s == null)
			return null;
		boolean[][] map = getMap(s);
		int l = -1;
		int r = -1;
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			l = i;
			r = i;
			while (l >= 0 && r < s.length() && map[l][r]) {
				if (right - left + 1 < r - l + 1) {
					left = l;
					right = r;
				}
				l--;
				r++;
			}
			l = i;
			r = i + 1;
			while (l >= 0 && r < s.length() && map[l][r]) {
				if (right - left + 1 < r - l + 1) {
					left = l;
					right = r;
				}
				l--;
				r++;
			}
		}
		return s.substring(left, right + 1);
	}

	private boolean[][] getMap(String s) {

		boolean[][] res = new boolean[s.length()][s.length()];
		int l;
		int r;
		for (int i = 0; i < s.length(); i++) {
			l = i;
			r = i;
			while (l >= 0 && r < s.length()) {
				if (s.charAt(l) == s.charAt(r)) {
					res[l][r] = true;
					l--;
					r++;
				} else {
					break;
				}
			}
			l = i;
			r = i + 1;
			while (l >= 0 && r < s.length()) {
				if (s.charAt(l) == s.charAt(r)) {
					res[l][r] = true;
					l--;
					r++;
				} else {
					break;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindrome x = new LongestPalindrome();
		System.out
				.println(x
						.longestPalindrome("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));

	}

}
