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
        int down = getLocation(image, x, image.length -1, true, false);
        int left = getLocation(image,0, y, false, true);
        int right = getLocation(image, y, image[x].length-1, false, false);
        return (down - up + 1) * (right - left + 1);
    }
    
    private int getLocation(char[][] image, int start, int end, boolean isRow, boolean getSmallerBoundary) {
    	if(start == end) return start;
    	int m = (start + end) / 2;
    	if(isRow) {
    		if(getSmallerBoundary) {
    			for(int i = 0 ; i < image[m].length; i++) {
    				if(image[m][i] == '1') {
    					return getLocation(image, start, m, isRow, getSmallerBoundary);
    				}
    			}
				return getLocation(image, m+1, end, isRow, getSmallerBoundary);
    		} else {
    			for(int i = 0 ; i < image[m].length; i++) {
    				if(image[m][i] == '1') {
    					if(start == end - 1) {
    						//edge case when searching for the boundary.
    						for(int j = 0 ; j < image[m].length;j++) {
    							if(image[end][j] == '1') return end;
    						}
    						// start == m;
    						return start;
    					}
    					return getLocation(image, m, end, isRow, getSmallerBoundary);
    				}
    			}
				return getLocation(image, start, m-1, isRow, getSmallerBoundary);
    		}
    	} else {
    		if(getSmallerBoundary) {
    			for(int i = 0 ; i < image.length; i++) {
    				if(image[i][m] == '1') {
    					return getLocation(image, start, m, isRow, getSmallerBoundary);
    				}
    			}
				return getLocation(image, m+1, end, isRow, getSmallerBoundary);
    		} else {
    			for(int i = 0 ; i < image.length; i++) {
    				if(image[i][m] == '1') {
    					if(start == end - 1) {
    						//edge case when searching for the boundary.
    						for(int j = 0 ; j < image.length;j++) {
    							if(image[j][end] == '1') return end;
    						}
    						return start;
    					}
    					return getLocation(image, m, end, isRow, getSmallerBoundary);
    				}
    			}
				return getLocation(image, start, m-1,isRow, getSmallerBoundary);
    		}
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
