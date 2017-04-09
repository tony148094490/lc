package kc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Candy {
    public int candy(int[] ratings) {
        if(ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;
        int[] res = new int[ratings.length];
        res[0] = 1;
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                res[i] = res[i-1] + 1;
            } else {
                res[i] = 1;
            }
        }
        
        for(int i = ratings.length-2; i >= 0 ;i--) {
            if(ratings[i] > ratings[i+1] && res[i] <= res[i+1]) {
                res[i] = res[i+1] + 1;
            }
        }
        int sum = 0;
        for(int x : res) sum += x;
        return sum;
    }
    
    public static void main(String[] args) {
		int[] arr = {4,2,3,4,1};
		Candy x = new Candy();
		String line = "AddressLine1=xxxxxx, AddressLine2=xxxxxx,";
		String pattern = "[Aa]ddressLine(1|2)=.*?,";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		System.out.println(m.replaceAll("AddressLine1=***,"));
	}
}
