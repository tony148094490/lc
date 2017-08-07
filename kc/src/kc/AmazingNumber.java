package kc;

public class AmazingNumber {
	public int amazing(int[] arr) {
		int n = arr.length;
		int[] shifts = new int[n];
		
		// in this array, the max boundary is n-1, the min boundary is 0.
		for(int i = 0 ; i < n; i++) {
			if(arr[i] <= 0 || arr[i] >= n) continue;
			
			if(arr[i] > i) {
				// left boundary (actually right boundary) inclusive
				shifts[i+1]++; //max index you can get
				
				// right boundary (actually left boundary) exclusive
				// keep rightshifting (n-arr[i]) to locate the boundary
				if(i+1 + (n - arr[i]) < n) {
					shifts[i+1+n-arr[i]]--;
				}
			} else {
				shifts[0]++;
				
				// move less to find one boundary
				shifts[i+1-arr[i]]--;
				
				// right boundary the same as before
				if(i+1 < n) shifts[i+1]++;
			}
		}
		
		int sum = 0, max = 0, index = 0;
		for(int i = 0 ; i < shifts.length; i++) {
			sum += shifts[i];
			if(sum > max) {
				max = sum;
				index = i;
			}
		}
		return index;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println("abc".indexOf("d"));
	}
}
