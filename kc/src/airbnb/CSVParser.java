package airbnb;

import java.util.ArrayList;
import java.util.List;

/*
input:

John,Smith,john.smith@gmail.com,Los Angeles,1
Jane,Roberts,janer@msn.com,"San Francisco, CA",0
"Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
"""Alexandra Alex"""
""""Alexandra Alex""""
"""""Alexandra Alex"""""
""""""AAA AAA""""""

return:

John|Smith|john.smith@gmail.com|Los Angeles|1
Jane|Roberts|janer@msn.com|San Francisco, CA|0
Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
"Alexandra Alex"
"Alexandra Alex"

http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=154363
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=140445
*/
public class CSVParser {
	// idea is that we keep every other consecutive double quote and 
	public String parseCSV(String input) {
		if(input.isEmpty() || input.length() == 0) return "";
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		boolean inQuote = false;
		for(int i = 0 ; i < input.length(); i++) {
			char c = input.charAt(i);
			if(inQuote) {
				if(c == '"') {
					if(i + 1 < input.length() && input.charAt(i+1) == '"') {
						sb.append(c);
						i++;
					} else {
						inQuote = false;
					}
				} else {
					sb.append(c);
				}
			} else {
				if(c == '"') {
					inQuote = true;
				} else {
					if(c == ',') {
						res.add(sb.toString());
						sb = new StringBuilder();
					} else {
						sb.append(c);
					}
				}
			}
		}
		if(sb.length() > 0) res.add(sb.toString());
		sb = new StringBuilder();
		for(String str : res) {
			sb.append(str).append("|");
		}
		return sb.substring(0, sb.length()-1);
	}
	
	// from web
	public String parseCSV2(String input) {
        if (input == null || input.isEmpty()) return "";
        List<String> items = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuote = false;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (inQuote) {
                if (ch == '\"') {
                    if (i < input.length() - 1 && input.charAt(i+1) == '\"') {
                        sb.append("\"");
                        i++;
                    } else {
                        inQuote = false;
                    }
                } else {
                    sb.append(ch);
                }
            } else {
                if (ch == '\"') {
                    inQuote = true;
                } else if (ch == ',') {
                    items.add(sb.toString());
                    sb.delete(0, sb.length());
                } else {
                    sb.append(ch);
                }
            }
        }
        if (sb.length() != 0) items.add(sb.toString());
        sb.delete(0, sb.length());
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i));
            if (i < items.size() - 1) {
                sb.append("|");
            }
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		
		String test1 = "\"\"\"Alexandra Alex\"\"\"";
		String test2 = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1";
		String test3 = "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0";
		String test4 = "a,\"c,\"\"1\"\"\",2,2,a\"b";
		String test5 = "\"\"\"\" AA \"\"\"\"";
		String test6 = "\"\"\"\"\" AA \"\"\"\"\"";
		String test7 = "\"\"\"\"\"\" AA \"\"\"\"\"\"";
		String test8 = "\"\"\"\"\"\"\" AA \"\"\"\"\"\"\"";
		String test9 = "John,Smith,john.smith@gmail.com,Los Angeles,1";
		
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
        System.out.println(test4);
        System.out.println(test5);
        System.out.println(test6);
        System.out.println(test7);
		System.out.println("---------");
		CSVParser c = new CSVParser();
        System.out.println(c.parseCSV(test1));
        System.out.println(c.parseCSV(test2));
        System.out.println(c.parseCSV(test3));
        System.out.println(c.parseCSV(test4));
        System.out.println(c.parseCSV(test5));
        System.out.println(c.parseCSV(test6));
        System.out.println(c.parseCSV(test7));
        System.out.println(c.parseCSV(test8));
        System.out.println(c.parseCSV(test9));
		System.out.println("---------");
        System.out.println(c.parseCSV2(test1));
        System.out.println(c.parseCSV2(test2));
        System.out.println(c.parseCSV2(test3));
        System.out.println(c.parseCSV2(test4));
        System.out.println(c.parseCSV2(test5));
        System.out.println(c.parseCSV2(test6));
        System.out.println(c.parseCSV2(test7));
        System.out.println(c.parseCSV2(test8));
        System.out.println(c.parseCSV2(test9));

	}
}























