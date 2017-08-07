package fb;

import java.util.HashSet;
import java.util.Set;

public class KSum {
	public boolean findSubarray(int[] input, int k)  {
		Set<Integer> previous = new HashSet<>();
		previous.add(0);
		int runningSum = 0;
		for(int i : input) {
			runningSum += i;
			if(previous.contains(runningSum - k)) {
				return true;
			} else {
				previous.add(runningSum);
			}
		}
		return false;
	}
}
