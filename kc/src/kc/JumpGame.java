package kc;

public class JumpGame {

    public boolean canJump(int[] nums) {
    	if(nums.length == 0) return false;
    	
    	int reachability = nums[0];
    	
    	for(int i = 1 ; i < nums.length ; i++) {
    		if(reachability < i) return false;
    		reachability = Math.max(reachability, i + nums[i]);
    	}
        
    	return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {2,3,1,1,4};
		int[] B = {3,2,1,0,4};
		JumpGame sol = new JumpGame();
		System.out.println(sol.canJump(A));
		System.out.println(sol.canJump(B));

	}

}
