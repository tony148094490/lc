package fb;

import java.util.ArrayList;
import java.util.List;

public class AddOperator {
	public List<String> addOperator(String number) {
		List<String> res = new ArrayList<>();
		dfs(number, 0, "", res);
		return res;
	}
	
	private void dfs(String number, int index, String cur, List<String> res) {
		if(index == number.length()) {
			if(cur.charAt(0) == '+') {
				cur = cur.substring(1);
			}
			res.add(cur);
			return;
		} else {
			for(int i = index ; i < number.length(); i++) {
				if(i > index && number.charAt(i) == '0') return;
				String newString = number.substring(index, i+1);
				dfs(number, i + 1, cur + "+" + newString, res);
				dfs(number, i + 1, cur + "-" + newString, res);
			}
		}
	}
	
	public static void main(String[] args) {
		AddOperator x = new AddOperator();
		System.out.println(x.addOperator("12345"));
	}
}
