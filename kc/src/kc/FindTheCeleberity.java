package kc;

public class FindTheCeleberity {
	
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }
        
        for(int i = 0 ; i < n ;i++) {
            if(i == candidate) continue;
            if(!knows(i,candidate) || knows(candidate, i)) return -1;
        }
        return candidate;
    }
    
    
    public int findCelebrityNSqure(int n) {
        if(n < 2) return -1;
        int[] arr = new int[n];
        
        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(i == j) continue;
                if(knows(i,j)) {
                    if(arr[j] != -1)
                    arr[j]++;
                    arr[i] = -1;
                }
            }
        }
    
        for(int i = 0 ; i < n; i++) {
            if(arr[i] == n - 1) return i;
        }
        return -1;
    }
    
    boolean knows(int a, int b) {
    	return true;
    }

}
