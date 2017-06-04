package kc;

public class MaxProfitWithCharge {
	public int max(int[] arr, int charge) {
		int profit = 0;
		int running = 0;
		boolean sold = false;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[i-1]) {
				running += arr[i]-arr[i-1];
				if(!sold) running -= charge;
				sold = true;
			} else {
				if(sold) {
					profit += running > 0 ? running : 0;
					running = 0;
					sold = false;
				}
			}
		}
		
		if(running > 0) profit += running;
		
		return profit;
	}
}
