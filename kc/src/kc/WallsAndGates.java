package kc;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0) return;
        for(int i = 0 ; i < rooms.length; i++) {
            for(int j = 0 ; j < rooms[i].length; j++) {
                if(rooms[i][j] == 0) {
                    helper(rooms, i-1, j, 0);
                    helper(rooms, i+1, j, 0);
                    helper(rooms, i, j-1, 0);
                    helper(rooms, i, j+1, 0);
                }
            }
        }
    }
    
    private void helper(int[][] rooms, int i, int j, int last) {
        //compare around with parent
        if(i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length) return;
        if(rooms[i][j] == -1 || rooms[i][j] == 0) return;
        int d = last + 1;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE, up = Integer.MAX_VALUE,
        		down = Integer.MAX_VALUE;
        if(j > 0 && rooms[i][j-1] != -1) {
            left = rooms[i][j-1];
        }
        if(j < rooms[0].length - 1 && rooms[i][j+1] != -1) {
            right = rooms[i][j+1];
        }
        if(i < rooms.length - 1 && rooms[i+1][j] != -1) {
            down = rooms[i+1][j];
        }
        if(i > 0 && rooms[i-1][j] != -1) {
            up = rooms[i-1][j];
        }
        
        // get the reuslt
        d = Math.min(d, Math.min(left, Math.min(right, Math.min(up, down))) + 1);
        rooms[i][j] = d;
        
        // recurse if necessary
        if(left > d + 1) {
            helper(rooms,i,j-1, d);
        }
        if(right > d + 1) {
            helper(rooms,i,j+1,d);
        }
        if(up > d + 1) {
            helper(rooms,i-1,j,d);
        }
        if(down > d + 1) {
            helper(rooms, i+1, j, d);
        }
    }
    
    public static void main(String[] args) {
    	System.out.println("abc".substring(0));
    	int[][] arr = new int[4][4];
    	int max = Integer.MAX_VALUE;
    	arr[0][0] = max;
    	arr[0][1] = -1;
    	arr[0][2] = 0;
    	arr[0][3] = max;
    	
    	arr[1][0] = max;
    	arr[1][1] = max;
    	arr[1][2] = max;
    	arr[1][3] = -1;
    	
    	arr[2][0] = max;
    	arr[2][1] = -1;
    	arr[2][2] = max;
    	arr[2][3] = -1;
    	
    	arr[3][0] = 0;
    	arr[3][1] = -1;
    	arr[3][2] = max;
    	arr[3][3] = max;
    	
    	WallsAndGates x = new WallsAndGates();
    	x.wallsAndGates(arr);
    	for(int i = 0 ; i < arr.length; i++) {
    		for(int j = 0 ; j < arr[i].length; j++) {
    			System.out.print(arr[i][j] + ",");
    		}
    		System.out.println();
    	}
    	
	}
}
