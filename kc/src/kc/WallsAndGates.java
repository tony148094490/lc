package kc;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0) return;
        for(int i = 0 ; i < rooms.length; i++) {
            for(int j = 0 ; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    helper(rooms, i+1, j, 1);
                    helper(rooms, i-1, j, 1);
                    helper(rooms, i, j+1, 1);
                    helper(rooms, i, j-1, 1);
                }
            }
        }
    }
    
    private void helper(int[][] rooms, int i, int j, int cur) {
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) return;
        if(rooms[i][j] == -1 || rooms[i][j] == 0) return;
        if(cur >= rooms[i][j]) return;
        rooms[i][j] = cur;
        helper(rooms, i+1, j, cur+1);
        helper(rooms, i-1, j, cur+1);
        helper(rooms, i, j+1, cur+1);
        helper(rooms, i, j-1, cur+1);
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
