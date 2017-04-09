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
        	System.out.println(two + "," + one);

        	//adjust the one and two if needed
        	mask = ~(one & two);
        	
        	one = mask & one;
        	two = mask & two;
        	
        }
        
        return one;
    }
    
    public int[] singleNumber3(int[] nums) {
        if(nums.length < 2) return null;
        int[] res = new int[2];
        int xor = nums[0];
        for(int i = 1; i < nums.length; i++){
            xor ^= nums[i];
        }

        int one = 1;
        while((xor & one) == 0) {
            one <<= 1;
        }
        
        Integer a = null;
        Integer b = null;
        
        for(Integer x : nums) {
            if((x & one) != 0) {
                if(a == null) {
                    a = x;
                } else {
                    a = a ^ x;
                }
            } else {
                if(b == null) {
                    b = x;
                } else {
                    b = b ^ x;
                }
            }
        }
        res[0] = a;
        res[1] = b;
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingeNumber x = new SingeNumber();
		int[] arr = {1,1,1,3};
		int res = x.singleNumber2(arr);
		
	}

}
