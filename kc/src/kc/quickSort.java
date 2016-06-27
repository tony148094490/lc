package kc;

public class quickSort {

	public void sort(int[] arr) {
		//choose far left as the pivot point		
		sort(arr, 0, arr.length -1 );
	}
	
	private void sort(int[] arr, int leftMost, int rightMost) {
		if (leftMost >= rightMost) {
			return;
		}
		int sortedPosition = partition(arr, leftMost, leftMost + 1, rightMost);
		sort(arr, leftMost, sortedPosition -1);
		sort(arr, sortedPosition + 1, rightMost);
		
	}

	private int partition(int[] arr, int pivotIndex, int leftMost, int rightMost) {
		int end = rightMost;
		int start = pivotIndex;
		
		while (true) {
			while (leftMost < end  && arr[leftMost] < arr[pivotIndex])  {
				leftMost++;
			}
			while (start < rightMost && arr[rightMost] > arr[pivotIndex]) {
				rightMost--;
			}
			
			if (leftMost < rightMost) { 
				swap(arr, leftMost, rightMost);
			}else {
				break;
			}
		}
		
		// swap at the end
		// Depends on the starting pivot, this may be swap(arr, pivotIndex, leftMost)
		swap(arr,pivotIndex, rightMost);
		return rightMost;
	
	}

	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,4,3,2,5};
		int[] arr1 = {2,3,4};
		int[] arr2 = {4,3,2,5};
		int[] arr3 = {1,2,3,4,5};
		int[] arr4 = {5,5,3,2,1};
		
//		quickSort s = new quickSort();
//		s.sort(arr4);
//		
		TwoSum t = new TwoSum();
		t.quickSort(arr);
		
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + ",");
		}
	}

}