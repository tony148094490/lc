package fb;

import java.util.Arrays;

// 70
public class FindThief {

	// assumption is the thief will play for win, thus it yields the upper bound for our problem
	public boolean canFindThief(int rooms, int[] sequence) {
		boolean[] notTheHidingSpots = new boolean[rooms];
		
		notTheHidingSpots[sequence[0]] = true;
		
		for(int i = 1; i < sequence.length; i++) {
			boolean[] lastNight = Arrays.copyOf(notTheHidingSpots, rooms);
			for(int j = 0 ; j < notTheHidingSpots.length; j++) {
				if(j == 0) {
					notTheHidingSpots[j] = lastNight[1];
				} else if(j == rooms - 1) {
					notTheHidingSpots[j] = lastNight[rooms-1];
				} else {
					notTheHidingSpots[j] = lastNight[j+1] && lastNight[j-1];
				}
			}
			notTheHidingSpots[sequence[i]] = true;

		}
		
		boolean found = true;
		for(boolean x : notTheHidingSpots) found &= x;
		return found;
	}
}
