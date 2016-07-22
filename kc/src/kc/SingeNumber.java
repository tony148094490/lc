package kc;

public class SingeNumber {
    public int singleNumber(int[] nums) {
        int x = 0;
        for(Integer a : nums) {
            x = x ^ a;
        }
        return x;
    }
    
    public int singleNumber2(int[] nums) {
        int one = 0;
        int two = 0;
        int mask = 0;
        for(Integer x : nums) {
        	two = two ^ (one & x); 
        	one = one ^ x; 
        	
        	mask = ~(one & two);
        	
        	one = mask & one;
        	two = mask & two;
        }
        
        return one;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingeNumber x = new SingeNumber();
		int[] arr = {1,2,1,2,2,1,3,3,3,4};
		System.out.println(x.singleNumber2(arr));
	}

}
