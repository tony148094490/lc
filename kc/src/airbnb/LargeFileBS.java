package airbnb;
// https://tinyurl.com/ycb9qz7c
// find median from large file of integers
public class LargeFileBS {

	
	public int getMedian(int[] arr, int lower, int higher, int nr) {
		int guess = lower + (higher - lower) / 2;
		int candidate = Integer.MAX_VALUE;
		int count = 0;
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i] < guess) count++;
			if(arr[i] >= guess) candidate = Math.min(candidate, arr[i]);
		}
		
		if(count == nr / 2) return candidate;
		if(count < nr / 2) {
			return getMedian(arr, guess+1, higher, nr);
		} else {
			return getMedian(arr, lower, guess-1, nr);
		}
	}
	
	
}
