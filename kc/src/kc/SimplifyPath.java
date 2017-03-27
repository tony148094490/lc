package kc;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for(String str : strs) {
            if(str.length() == 0 || str.equals(".")) continue;
            if(str.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if(!str.equals("..")) {
                stack.push(str);
            }
        }
        if(stack.isEmpty()) return "/";
        Stack<String> res = new Stack<>();
        while(!stack.isEmpty()) res.push(stack.pop());
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
