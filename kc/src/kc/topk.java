package kc;


public class topk {
	 // B2
    /*
    More optimal, but hard to read O(n). Candidate would probably recognize the
    modified quick sort
    */
    public static Integer[] topKLargest2(Integer[] input, int k) {
        if (input == null || input.length == 0)
            return null;
 
        // pick the pivot as the kth elt
        int middle = k - 1;
        Integer pivot = input[middle];
 
        // make left < pivot and right > pivot
        int i = 0, j = input.length - 1;
        while (i <= j) {
            while (input[i].compareTo(pivot) < 0) {
                i++;
            }
 
            while (input[j].compareTo(pivot) > 0) {
                j--;
            }
 
            if (i <= j) {
                Integer temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }
 
        Integer[] out = new Integer[k];
        for (i = 0; i < out.length; i++) {
            out[i] = input[i];
        }
        return out;
    }
  
    
    
    public static void main(String[] args) throws InterruptedException {
    		Integer[] arr = new Integer[11];
    		arr[0] = 1;
    		arr[1] = 5;
    		arr[2] = 2;
    		arr[3] = 3;
    		arr[4] = 4;
    		arr[5] = -1;
    		arr[6] = -4;
    		arr[7] = 10;
    		arr[8] = 7;
    		arr[9] = -2;
    		arr[10] = 9;
    		Integer[] res = topk.topKLargest2(arr, 4);
    		for(Integer x : res) System.out.println(x);
    		
    }
}
