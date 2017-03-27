package kc;
import java.util.UUID;
/**
The idea is to get the balloon bursted last and apply dp.
While doing dp, we do from the smallest range, which consists three numbers. 
While progressing, we increase the range and then we fix the boudnary and examine each
number inside the range and see what's the points of using dp[start][i] + dp[i][end] + start*i*end
iterate through all the elements inside will give us the number who should burst last within that range

 */
public class BurstBallons {
    public int maxCoins(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int[] arr = new int[nums.length+2];
        arr[0] = arr[nums.length+1] = 1;
        for(int i = 1; i < arr.length-1;i++) {
            arr[i] = nums[i-1];
        }
        
        int[][] coins = new int[nums.length+2][nums.length+2];
        for(int range = 2; range < arr.length; range++) {
            for(int start = 0; start + range < arr.length; start++) {
                for(int index = start + 1 ; index < start + range; index++) {
                    coins[start][start + range] = Math.max(coins[start][start + range],
                        arr[start] * arr[index] * arr[start + range] + coins[start][index] + 
                        coins[index][start + range]);
                }
            }
        }
        return coins[0][arr.length-1];
    }
        
    public static void main(String[] args) {
    	BurstBallons x = new BurstBallons();
    	int[] arr = {3,1,5,8};

    	System.out.println(UUID.randomUUID());
    }
}

