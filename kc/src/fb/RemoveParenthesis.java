package fb;

public class RemoveParenthesis {

	public String removePar(String s) {
		int left = 0;
		int right = 0;
		for(int i = 0 ; i < s.length(); i++) {
			if(s.charAt(i) == ')') {
				if(left == 0) {
					right++;
				} else {
					left--;
				}
			} else if(s.charAt(i) == '(') {
				left++;
			}
		}
		StringBuilder sb = new StringBuilder(s);
		int i = s.length() - 1;
		while(left > 0 && i >= 0) {
			if(sb.charAt(i) == '(') {
				sb.deleteCharAt(i);
				left--;
			} else {
				i--;
			}
		}
		
		i = 0;
		while(right > 0 && i < sb.length()) {
			if(sb.charAt(i) == ')') {
				sb.deleteCharAt(i);
				right--;
			} else {
				i++;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		RemoveParenthesis x = new RemoveParenthesis();
		System.out.println(x.removePar("(()()"));
		System.out.println(x.removePar(")((()"));

	}
}
