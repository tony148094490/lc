package kc;
/**
 * An image is represented by a binary matrix with 0 
 * as a white pixel and 1 as a black pixel. 
 * The black pixels are connected, i.e., 
 * there is only one black region. Pixels are connected 
 * horizontally and vertically. Given the location (x, y) 
 * of one of the black pixels, return the area of the 
 * smallest (axis-aligned) rectangle that encloses all black pixels.
For example, given the following image:
[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6. 
 */
public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        int up = getLocation(image, 0, x, true, true);
        int down = getLocation(image, x, image.length-1, true, false);
        int left = getLocation(image, 0, y, false, true);
        int right = getLocation(image, y, image[0].length-1, false, false);
        return (down - up + 1) * (right - left + 1);
    }
    
    
    private int getLocation(char[][] image, int low, int high, boolean isRow, boolean getLowerBound) {
        if(low == high) return low;
        if(low + 1 == high) {
            if(isRow) {
                if(getLowerBound) {
                    if(contains(image,low,0,isRow)) return low;
                    return high;
                }
                if(contains(image, high, 0, isRow)) return high;
                return low;
            } else {
                if(getLowerBound) {
                    if(contains(image,0, low, isRow)) return low;
                    return high;
                }
                if(contains(image, 0, high, isRow)) return high;
                return low;
            }
        }
        int mid = (low + high) / 2;
        if(isRow) {
            if(getLowerBound) {
                boolean contain = contains(image, mid, 0, isRow);
                if(contain) {
                    return getLocation(image, low, mid, isRow, getLowerBound);
                } else {
                    return getLocation(image, mid + 1, high, isRow, getLowerBound);
                }
            } else {
                boolean contain = contains(image, mid, 0, isRow);
                if(contain) {
                    return getLocation(image, mid, high, isRow, getLowerBound);
                } else {
                    return getLocation(image, low, mid - 1, isRow, getLowerBound);
                }
            }
        } else {
            if(getLowerBound) {
                if(contains(image, 0, mid, isRow)) {
                    return getLocation(image, low, mid, isRow, getLowerBound);
                }
                return getLocation(image, mid+1,high, isRow, getLowerBound);
            } else {
                if(contains(image, 0, mid, isRow)) {
                    return getLocation(image, mid, high, isRow, getLowerBound);
                }
                return getLocation(image, low, mid-1, isRow, getLowerBound);
            }
        }
    }
    
    private boolean contains(char[][] image, int row, int col, boolean isRow) {
        if(isRow) {
            for(int i = 0 ; i < image[row].length; i++) {
                if(image[row][i] == '1') return true;
            }
            return false;
        } else {
            for(int i = 0 ; i < image.length; i++) {
                if(image[i][col] == '1') return true;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
    	SmallestRectangleEnclosingBlackPixels x = new SmallestRectangleEnclosingBlackPixels();
    	char[][] arr = new char[5][5];
    	arr[0][0] = '0';
    	arr[0][1] = '0';
    	arr[0][2] = '0';
    	arr[0][3] = '1';
    	arr[0][4] = '0';
    	
    	arr[1][0] = '0';
    	arr[1][1] = '0';
    	arr[1][2] = '1';
    	arr[1][3] = '1';
    	arr[1][4] = '0';
    	
    	arr[2][0] = '0';
    	arr[2][1] = '0';
    	arr[2][2] = '1';
    	arr[2][3] = '0';
    	arr[2][4] = '0';
    	
    	arr[3][0] = '0';
    	arr[3][1] = '0';
    	arr[3][2] = '1';
    	arr[3][3] = '0';
    	arr[3][4] = '0';
    	
    	arr[4][0] = '1';
    	arr[4][1] = '1';
    	arr[4][2] = '1';
    	arr[4][3] = '0';
    	arr[4][4] = '0';
    	for(int i = 0 ; i < arr.length; i++) {
    		for(int j = 0 ; j < arr[0].length; j++) {
    			System.out.print(arr[i][j] + " ");
    		}
    		System.out.println();
    	}
    	
    	System.out.println(x.minArea(arr, 1, 3));
    	
    }
}
