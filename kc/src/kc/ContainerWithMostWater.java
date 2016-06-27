package kc;

public class ContainerWithMostWater {

	
	public int MaxArea(int[] height) {
        if (height.length == 0) return 0;

        int left = 0;

        int right = height.length - 1;

        int res = 0;

        while( left < right) {

            res = Math.max(res, Math.min(height[left],height[right]) * (right - left));

        

            if(height[left] > height[right]) {

                right--;

            }else{

                left++;

            }

        }

        return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
