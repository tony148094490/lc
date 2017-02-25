package kc;

public class SortTransformedArray {
    int aa;
    int bb;
    int cc;
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        this.aa = a;this.bb=b;this.cc=c;
        int[] res = new int[nums.length];
        if(a==0) {
            if(b >= 0) {
                for(int i = 0 ; i < nums.length; i++) {
                    res[i] = nums[i] * b + c;
                }
            } else {
                for(int i = nums.length - 1 ; i >= 0; i--) {
                    res[i] = nums[nums.length - 1 - i] * b + c;
                }
            }
            return res;
        }
        
        double peakx = (-1 * (double) b) / ((double) a * 2);
        int first = 0;
        int second = 0;
        while(first < nums.length && nums[first] < peakx) first++;
        second = first;
        first = first - 1;
        
        if(a > 0) {
            int counter = 0;
            while(counter < nums.length) {
                if(second == nums.length ||(first >= 0 && Math.abs((double) nums[second] - peakx) > Math.abs((double) nums[first] - peakx))) {
                    res[counter] = getNr(nums[first]);
                    first--;
                } else {
                    res[counter] = getNr(nums[second]);
                    second++;
                }
                counter++;
            }
        } else {
            int counter = nums.length-1;
            while(counter >=0 ) {
                if(second == nums.length ||(first >= 0 && Math.abs((double) nums[second] - peakx) > Math.abs((double) nums[first] - peakx))) {
                    res[counter] = getNr(nums[first]);
                    first--;
                } else {
                    res[counter] = getNr(nums[second]);
                    second++;
                }
                counter--;
            }
        }
        return res;
    }
    
    private int getNr(int x) {
        return aa * x * x + bb* x + cc;
    }
    
    public static void main(String[] args) {
    	int[] nums = {-99,-94,-90,-88,-84,-83,-79,-68,-58,-52,-52,-50,-47,-45,-35,-29,-5,-1,
    	    	 9,12,13,25,27,33,36,38,40,46,47,49,57,57,61,63,73,75,79,97,98};
    	int a = -2, b = 44, c = -56;
    	SortTransformedArray x = new SortTransformedArray();
    	int[] res = x.sortTransformedArray(nums, a, b, c);
    	for(int r : res) System.out.print(r + ",");
	}
}
