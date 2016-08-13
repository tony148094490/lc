package kc;

public class CountingBits {
    public int[] countBits(int num) {
    	if(num < 0) return null;
    	int[] arr = new int[num+1];
    	int twos = 1;
    	arr[0] = 0;
    	int i = 1;
    	
    	while(i <= num) {
    			arr[i] = 1;
    			twos = twos * 2;
    			i++;
    			int j = i;
    			while(i <= num && i < twos) {
    				arr[i] = arr[i - j + 1] + 1;
    				i++;
    			}
    	}
    	return arr;
    }
    
    public static void main(String[] args) {
    	CountingBits x= new CountingBits();
    	int[] arr = x.countBits(5);
    	for(Integer a : arr) System.out.print(a + ",");
	}
}
