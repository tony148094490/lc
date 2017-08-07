package fb;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    String[] pad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        dfs(digits, 0, new StringBuilder(), res);
        return res;
    }
    
    private void dfs(String str, int index, StringBuilder sb, List<String> res) {
        if(index == str.length()) {
            res.add(sb.toString());
            return;
        } else {
            String potential = pad[str.charAt(index) - '0'];
            for(char c : potential.toCharArray()) {
                sb.append(c);
                dfs(str, index+1,sb,res);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
