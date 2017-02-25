package kc;

public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        if(num == 0) return res;
        int two = 1;
        res[two] = 1;
        for(int i = 1; i <= num; i++) {
            if(two * 2 <= i) {
                two = two * 2;
                res[two] = 1;
            }
            res[i] = res[two] + res[i-two];

        }
        return res;
    }
    
    public static void main(String[] args) {
    	CountingBits x= new CountingBits();
    	int[] arr = x.countBits(5);
    	for(Integer a : arr) System.out.print(a + ",");
	}
}
