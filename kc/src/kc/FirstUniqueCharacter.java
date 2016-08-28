package kc;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            if(arr[c] == -1) continue;
            if(arr[c] == 0) {
                arr[c] = i + 1;
            } else {
                arr[c] = -1;
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length; i++) {
            if(arr[i] != 0 && arr[i] != -1) {
                mini = Math.min(mini, arr[i]);
            }
        }
        if(mini == Integer.MAX_VALUE) return -1; 
        return mini - 1;
    }
    public static void main(String[] args) {
    	FirstUniqueCharacter x = new FirstUniqueCharacter();
    	System.out.println(x.firstUniqChar("leetcode"));
	}
}
