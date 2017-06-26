package airbnb;
/**http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=129199
 * Provide a set of positive integers (an array of integers). 
 * Each integer represent number of nights user request on Airbnb.com. 
 * If you are a host, you need to design and implement an algorithm 
 * to find out the maximum number a nights you can accommodate. 
 * The constrain is that you have to reserve at least one day between
 *  each request, so that you have time to clean the room. 
 *  
1) Input: [1, 2, 3] output: 4, because you will pick 1 and 3
2) input: [5,1, 2, 6] output: 11, because you will pick 5 and 6
3) input: [5,1, 2, 6, 20, 2] output: 27, because you will pick 5, 2, 20  
4) input: [5, 1, 1, 5] output: 10
5) input: [4,9,6] output 10
6) input: [4,10,3,1,5] output 15
 */
public class AccommodateMostNights {
	// this is to get the largest non-continuous sum in array, which is exactly the same as house robber
	public int getMost(int[] arr) {
		if(arr == null || arr.length == 0) return 0;
		if(arr.length == 1) return arr[0];
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		for(int i = 2; i < arr.length; i++) {
			dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
		}
		return dp[dp.length-1];
	}
	
	public static void main(String[] args) {
		AccommodateMostNights sol = new AccommodateMostNights();
		int[] testA = {1,2,3};
		int[] testB = {5,1,2,6};
		int[] testC = {5,1,2,6,20,2};
		int[] testD = {5,1,1,5};
		int[] testE = {4,9,6};
		int[] testF = {4,10,3,1,5};
		System.out.println(sol.getMost(testA)); // expect 4
		System.out.println(sol.getMost(testB)); // 11
		System.out.println(sol.getMost(testC)); // 27
		System.out.println(sol.getMost(testD)); // 10
		System.out.println(sol.getMost(testE)); // 10
		System.out.println(sol.getMost(testF)); // 15
		
		System.out.println("abc".startsWith(""));
	}
}
