package kc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductOfArray {

	public List<Integer> product(int[] arr) {
		Set<Integer> res = new HashSet<>();
		helper(arr, 0, 1, res);
		return new ArrayList<Integer>(res);
	}
	
	private void helper(int[] arr, int index, int cur, Set<Integer> res) {
		if(index == arr.length) return;
		for(int i = index; i < arr.length; i++) {
			if(i > index && arr[i] == arr[i-1]) continue;
			res.add(cur * arr[i]);
			helper(arr,i+1, cur * arr[i], res);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,5,7};
		ProductOfArray x = new ProductOfArray();
		System.out.println(x.product(arr));
	}
}
