package kc;

public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        int cur = 0;
        if(height.length == 0) return 0;
        int left = height[0];
        for(int i = 1; i < height.length; i++) {
        	if(height[i] >= left) {
        		left = height[i];
        		res += cur;
        		cur = 0;
        	} else {
        		cur += (left - height[i]);
        	}
        }
        
        cur = 0;
        left = height[height.length-1];
        for(int i = height.length - 1; i >= 0; i--) {
        	if(height[i] > left) {
        		left = height[i];
        		res += cur;
        		cur = 0;
        	} else {
        		cur += (left - height[i]);
        	}
        }
        
        return res;
    }
    public static void main(String[] args) {
    	TrappingRainWater x = new TrappingRainWater();
    	int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println(x.trap(arr));
    	int[] arr2 = {2,0,2};
    	System.out.println(x.trap(arr2));
    	
    	
	}
}
