package kc;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        //factorial[0] = n; this padding can be added or not
        factorial[1] = 1;
        for(int i = 2; i <= n; i++) {
            factorial[i] = factorial[i-1] * i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(i);
        }
        
        k--; // to be zero based

        // idea is that assuming we take one character out, how many permutations we have for the rest
        // the extra appending is for the last case when we only have 1 character left and we need to
        // calculate the permutations for  1 - 1 = 0 character(s), which either we don't calculate
        // or we just return 0.
        StringBuilder res = new StringBuilder();
        for(int i = 1; i < n; i++) {
            int position = k / factorial[sb.length() - 1];
            res.append(sb.charAt(position));
            k = k - position * factorial[sb.length() - 1];
            sb.deleteCharAt(position);
        }
        res.append(sb.charAt(0));
        
        return res.toString();
    	
    }
    

    
    
    
    public static void main(String[] args) {
    	PermutationSequence x = new PermutationSequence();
    	
    	System.out.println(x.getPermutation(4, 14));
    	
    }
}
