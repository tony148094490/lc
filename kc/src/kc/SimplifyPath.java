package kc;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {

        if(path == null || path.length() == 0) return null;
		
		Stack<String> stack = new Stack<String>();
		
		for(int i = 0 ; i < path.length() ; i++) {
			if(path.charAt(i) == '/'){
				int j = i + 1;
				while(j < path.length() && path.charAt(j) != '/') {
					j++;
				}
				String cur = path.substring(i+1,j);
				if(cur != null && cur.length() > 0) {
					if(cur.equals("..")) {
						if(!stack.isEmpty()) {
							stack.pop();
						}
					} else if (!cur.equals(".")) {
						stack.push(cur);
					}
				}
				i = j - 1;
			}
		}
		
		if(stack.isEmpty()) return "/";
		
		Stack<String> res = new Stack<String>();
		
		while(!stack.isEmpty()) {
			res.push(stack.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		while(!res.isEmpty()) {
			sb.append("/");
			sb.append(res.pop());
		}
		return sb.toString();

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/"));
	}

}
