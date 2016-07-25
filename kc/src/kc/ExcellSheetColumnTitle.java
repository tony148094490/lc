package kc;

public class ExcellSheetColumnTitle {
    public String convertToTitle(int n) {
    	StringBuilder sb = new StringBuilder();
    	while(n > 0) {
    		sb.insert(0, (char) ('A' + (n-1)%26));
    		n = (n-1)/26;
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args) {
    	ExcellSheetColumnTitle x = new ExcellSheetColumnTitle();
    	System.out.println(x.convertToTitle(700));
    	//System.out.println(1%1);

	}
    
    
}
