package kc;

public class ReverseString {
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return s;
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length-1;
        while(i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}
