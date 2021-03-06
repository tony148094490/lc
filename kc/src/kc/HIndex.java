package kc;

public class HIndex {
    public int hIndex(int[] citations) {
        int[] p = new int[citations.length+1];
        for(Integer x : citations) {
            if(x >= p.length - 1){
                p[p.length-1]++;
            } else {
                p[x]++;
            }
        }
        
        int count = 0;
        for(int i = p.length-1;i>=0;i--) {
            if(count + p[i] >= i) return i;
            count += p[i];
        }
        
        return 0;
    }
    
    public int hIndexSorted(int[] citations) {
        return helper(citations, 0, citations.length-1, 0);
    }
    
    private int helper(int[] citations, int l, int r, int curMax) {
        
        if(l > r) {
            return curMax;
        }
        
        int m = (l + r) / 2;
        int nrOfElements = citations.length - m;
        
        if(citations[m] >= nrOfElements) {   
            curMax = Math.max(curMax, nrOfElements);
            return helper(citations, l, m - 1, curMax);
        } else {
            return helper(citations, m + 1, r, curMax);
        }
    }
    
    // method 2
    public int hIndex3(int[] citations) {
        return helper(citations, 0, citations.length);
    }
    
    private int helper(int[] arr, int low, int high) {
        if(low == high || arr[low] >= (arr.length - low)) return (arr.length - low);
        int mid = (high + low)/2;
        if(arr[mid] >= arr.length - mid) {
            if(arr[mid - 1] >= arr.length - (mid-1)) {
                return helper(arr, low, mid-1);
            } else {
                return (arr.length - mid);
            }
        } else {
            return helper(arr, mid + 1, high);
        }
    }
    
    
    public static void main(String[] args) {
    	HIndex x = new HIndex();
    	int[] arr = {1,2,3,4,5,6,7,8,9,10,11,11,11,11,11,11,11,11,13};
    	System.out.println(x.hIndex(arr));
    	System.out.println(x.hIndexSorted(arr));
	}
}
