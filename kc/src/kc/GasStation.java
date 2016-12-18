package kc;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	
    	int[] abs = new int[gas.length];
    	for(int i = 0 ; i < gas.length; i++){
    		abs[i] = gas[i] - cost[i];
    		
    	}
    	
    	for(int i = 0 ; i < abs.length; i++) {
    		if(abs[i] < 0) continue;
    		int reachTo = reachTo(abs,i);
    		if(reachTo == i) return i;
    		if(reachTo < i) return -1;
    		i = reachTo;
    	
    	}
    	return -1;
    }
    
    public int reachTo(int[] abs, int start) {
    	int counter = 0;
    	int runningSum = abs[start];
    	int end = start;
    	while (counter <= abs.length && runningSum >= 0) {
    		counter++;
    		if(counter == abs.length) return end;
    		start = (start + 1) % (abs.length);
    		runningSum += abs[start];
    	} 
    	return start;
    }
    
    public static void main(String[] args) {
    	int[] a = {1,2,3,3};
    	int[] b = {2,1,5,1};
    	GasStation x = new GasStation();
    	System.out.println(x.canCompleteCircuit(a, b));
    }
}
