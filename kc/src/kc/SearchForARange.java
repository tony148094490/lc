package kc;

// in a sroted array
public class SearchForARange {

	public int[] search(int[] arr, int target) {
		int left = bs(arr, 0, arr.length - 1, target, true);
		int right = bs(arr, 0 , arr.length - 1, target, false);
		int[] res = {left, right};
		return res;
	}
	
	// branch: true (go left), false (go right)
	private int bs(int[] arr, int left, int right, int target, boolean branch) {
		if(left > right) {
			return -1;
		}
		int m = (left + right) / 2;
		if(arr[m] == target) {
			if(branch == true) {
				int branchLeft = bs(arr, left, m - 1, target, branch);
				if(branchLeft != -1 ){
					return branchLeft;
				} else {
					return m;
				}
			} else {
				int branchRight = bs(arr, m + 1, right, target, branch);
				if(branchRight != -1) {
					return branchRight;
				} else {
					return m;
				}
			}
		} else {
			int branchLeft = bs(arr, left, m -1 , target, branch);
			if (branchLeft != -1) {
				return branchLeft;
			}
			return bs(arr, m + 1, right, target, branch);

		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,4,4,4,4,4,5};
		SearchForARange x = new SearchForARange();
		int[] res = x.search(arr, 4);
		System.out.println(res[0] + "," + res[1]);
		
	}
}
