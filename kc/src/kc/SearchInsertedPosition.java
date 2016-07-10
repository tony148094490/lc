package kc;

public class SearchInsertedPosition {

	public int search(int[] arr, int target) {
		if(arr.length == 0) return -1;
		return bs(arr, 0, arr.length - 1, target);
	}
	
	private int bs (int[] arr, int left, int right, int target) {
		if(left > right) return left;
		int m = (left + right) / 2;
		if(arr[m] == target) {
			return m;
		} else if (arr[m] > target) {
			return bs(arr, left, m - 1, target);
		} else {
			return bs(arr, m+1, right, target);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,9,10};
		SearchInsertedPosition x = new SearchInsertedPosition();
		System.out.println(x.search(arr, 8));
	}
}
