package airbnb;

import java.util.ArrayList;
import java.util.List;

/**
  Coding:给了一堆用户，每个用户有一堆想去的城市(用整数表示的)，这些城市是按照用户的喜好程度排序的，
  比如
    Mary:10, 2, 5, 20
    John: 3, 10, 5, 18
    Peter: 4, 3, 8
    Kate: 3, 7, 18, 1
    要求输出所有的城市，并且保持每个用户喜欢的顺序。其实就是topological sort.
 */
public class FavavateCities {
	public List<Integer> get(List<List<Integer>> list) {
		
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res = new ArrayList<>();
		int[] a = {10,2,5,20};
		int[] b = {3,10,5,20};
		int[] c = {4,3,8};
		int[] d = {3,7,18,1};
		FavavateCities x = new FavavateCities();
		
	}
}
