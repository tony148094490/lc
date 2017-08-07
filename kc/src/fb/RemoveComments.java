package fb;

public class RemoveComments {
 // // and /*
	
	public String remove(String code) {
		boolean singleLine = false;
		boolean multiLine = false;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < code.length(); i++) {
			if(singleLine && code.charAt(i) == '\n') {
				singleLine = false;
			} else if(multiLine && i + 1 < code.length() && code.charAt(i) == '*' && code.charAt(i+1) == '/') {
				multiLine = false;
				i+=1;
			} else if(singleLine || multiLine) {
				continue;
			} else if(i + 1 < code.length() && code.charAt(i) == '/' && code.charAt(i+1) == '/') {
				singleLine = true;
				i+=1;
			} else if(i+1 < code.length() && code.charAt(i) == '/' && code.charAt(i+1) == '*') {
				multiLine = true;
				i+=1;
			} else {
				sb.append(code.charAt(i));
			}
		}
		return sb.toString();
	}
}
