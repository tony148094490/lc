package fb;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s : tokens) {
            if(s.isEmpty()) continue;
            if(s.equals(".")) continue;
            if(s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if(!s.equals("..")){
                stack.push(s);
            }
        }
        
        String res = "";
        while(!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if(res.isEmpty()) res = "/";
        return res;
    }
}
