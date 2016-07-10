package kc;

public class CountAndSay {
	
	//1, 11, 21, 1211, 111221
	public String countNSay(int n) {
		StringBuilder sb = new StringBuilder();
		if(n <= 0) return sb.toString();
		sb.append(1);
		if(n == 1) return sb.toString();
		while ( n > 1) {
			n--;
			StringBuilder newSb = new StringBuilder();
			String lastString = sb.toString();
			for(int i = 0 ; i < lastString.length(); i++) {
				if(i < lastString.length() - 2 && lastString.charAt(i) == lastString.charAt(i+1) && lastString.charAt(i+2)
						== lastString.charAt(i)) {
					newSb.append(3);
					i = i+2;
				} else if (i < lastString.length() - 1 && lastString.charAt(i) == lastString.charAt(i+1)) {
					newSb.append(2);
					i = i+1;
				} else {
					newSb.append(1);
				}
				newSb.append(lastString.charAt(i));
				sb = newSb;
			}
			
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		CountAndSay x = new CountAndSay();
		System.out.println(x.countNSay(5));
	}
}
