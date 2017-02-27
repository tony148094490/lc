package kc;

public class EliminationGame {
    public int lastRemaining(int n) {
        boolean[] arr = new boolean[n+1];
        int cur = 1;
        int gap = 2;
        boolean forward = true;
        int res = 0;
        while(cur != -1) {
                if(!forward) {
                    while(cur >= 0) {
                        arr[cur] = true;
                        cur -= gap;
                    }
                    res = cur + gap;
                } else {
                    while(cur <= n) {
                        arr[cur] = true;
                        cur += gap;
                    }
                    res = cur - gap;
                }
                if(forward) {
                    cur = getLast(arr);
                } else {
                    cur = getFirst(arr);
                }
                gap *= 2;
                forward = !forward;
        }
        
        return res;
    }
    private int getLast(boolean[] arr) {
        for(int i = arr.length-1; i >= 1; i--) {
            if(arr[i] == false) return i;
        }
        return -1;
    }
    private int getFirst(boolean[] arr) {
        for(int i = 1 ; i < arr.length; i++) {
            if(arr[i] == false) return i;
        }
        return -1;
    }
    
    // idea is to move head only and stop when it cannot be moved further
    public int lastRemaining2(int n) {
        int head = 1;
        boolean forward = true;
        int remaining = n;
        int gap = 1;
        while(remaining > 1) {
            if(forward || remaining % 2 == 1) {
                head += gap; 
            }
            gap *= 2;
            forward = !forward;
            remaining /= 2;
        }
        return head;
    }
}
