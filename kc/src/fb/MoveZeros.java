package fb;

public class MoveZeros {
	public String removeChar(char[] input, char k) {
		int index = 0;
		int actual = 0;
		while(index < input.length) {
			if(input[index] != k) {
				input[actual] = input[index];
				actual++;
			}
			index++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < actual; i++) sb.append(input[i]);
		return sb.toString();
	}
	
	
	// no order required
	public int moveZero(int[] input) {
		int left = 0;
		int right = input.length - 1;
		while(left <= right) {
			while(left <= right && input[left] != 0) left++;
			while(left <= right && input[right] == 0) right--;
			if(left < right) {
				input[left] = input[right];
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		int[] input = {1,2,3,0,0,2};
		int[] input2 = {1,2,3,0,2};
		int[] input3 = {0,0,0,0,0};
		
		MoveZeros x = new MoveZeros();
		System.out.println(x.moveZero(input3));
	}
}
