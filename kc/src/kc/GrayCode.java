package kc;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	
    public List<Integer> grayCode(int n) {
    	List<Integer> res = new ArrayList<Integer>();
    	
    	if( n == 0) {
    		res.add(0);
    	} else {
    		List<Integer> last = grayCode(n-1);
    		
    		for(Integer x : last) {
    			res.add(x);
    		}
    		
    		for(int i = last.size() - 1 ; i >=0 ;i--){
    			int temp = last.get(i);
    			res.add(temp += (1 << (n-1)));
    		}
    		
    	}
        return res;
    }
	
	public static void main(String[] args) {
		GrayCode x = new GrayCode();
		System.out.println(x.grayCode(3));
	}

}
