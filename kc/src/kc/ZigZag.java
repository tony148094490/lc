package kc;

public class ZigZag {
	public String convert(String s, int numRows) {
		if (numRows == 0)
			return s;
		StringBuilder[] arr = new StringBuilder[numRows];

		int currentRow = 0;
		boolean goingDown = true;
		for (int i = 0; i < s.length(); i++) {
			
			if(arr[currentRow] == null) arr[currentRow] = new StringBuilder();
			
			arr[currentRow].append(s.charAt(i));

			if (goingDown) {
				currentRow++;
			} else {
				currentRow--;
			}

			if (currentRow == 0) {
				goingDown = true;
			}

			if (currentRow == numRows - 1) {
				goingDown = false;
			}
		}

		StringBuilder res = new StringBuilder();
		for (StringBuilder str : arr) {
			res.append(str.toString());
		}
		return res.toString();
	}

	public static void main(String[] args) {
		ZigZag x = new ZigZag();
		System.out.println(x.convert("PAYPALISHIRING", 6));
	}
}
