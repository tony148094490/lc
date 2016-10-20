package kc;

/**
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167 

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBallons {
    public int maxCoins(int[] nums) {
        int[] actualNums = new int[nums.length + 2];
        for(int i = 0; i < nums.length; i++) {
        	actualNums[i+1] = nums[i];
        }
        actualNums[0] = actualNums[nums.length+1] = 1;
        int[][] dp = new int[actualNums.length][actualNums.length];
        for(int gap = 2; gap < actualNums.length; gap++) {
        	for(int left = 0; left + gap < actualNums.length;left++) {
        		for(int i = left + 1; i < left + gap; i++) {
        			dp[left][left+gap] = Math.max(dp[left][left+gap],
        					actualNums[left] * actualNums[i] * actualNums[left+gap] + dp[left][i] + dp[i][left+gap]);
        		}
        	}
        }
        return dp[0][actualNums.length-1];
    }
}
