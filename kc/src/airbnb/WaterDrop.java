package airbnb;

import java.util.ArrayList;
import java.util.List;

/*

*   http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=218383
	http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=279000
	http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=244524
* 	https://tinyurl.com/yakaj5he (has a very good/complex solution)
* 
* 1. water land。 比如terrian是[3,2,1,2] print出来就是
	*
	* *   *
	* * * *
	* * * *
然后给你一个dumpPoint，一个waterAmount，比如dumpPoint 1, waterAmount 2，因为有重力，所以是从index 2开始加水
 	* w
 	* * w *
 	* * * *
 	* * * *
*  hint是，假如waterAmount是1，这个怎么流.
* 
* 
 Idea 1:
 (0）handle the water drop by drop。 there are infinitely high walls on the left and right.
（1）水先向左走，走到不能走为止。call it leftMost  
（2）如果leftmost的水比开始点低，leftMost水+1，done
（3）如果leftmost的水不比开始点低，水向右走，走到不能走为止。call it rightMost
（4）如果rightmost的水比开始点低，rightMost水+1，done
（5）如果rightmost的水不比开始点低，leftMost水+1，done
	Assumptions were made, need to be talked with interviewer. The below assumption might work but might not work as 
	interviewer might ask you to evenly distribute the water if it's pouring toward a peak 

Idea 2:
https://tinyurl.com/yakaj5he
*/

public class WaterDrop {
		// this is the impl of the simple situation (idea 1)
		public int[] getMap(int[] terrian, int dumpPoint, int waterAmount) {
						
			while(waterAmount > 0) {
				int cur = dumpPoint;
				while(cur > 0 && terrian[cur-1] <= terrian[cur]) cur--;
				int leftMost = cur;
				
				if(terrian[leftMost] < terrian[dumpPoint]) {
					terrian[leftMost]++;
				} else {
					cur = dumpPoint;
					while(cur < terrian.length - 1 && terrian[cur] >= terrian[cur+1]) cur++;
					int rightMost = cur;
					
					if(terrian[rightMost] < terrian[dumpPoint]) {
						terrian[rightMost]++;
					} else {
						terrian[leftMost]++;
					}
				}
				
				waterAmount--;
			}
			return terrian;
		}
		
		public static void main(String[] args) {
			int[] terrian = {3,2,1,2};
			print(terrian);

			
			terrian = new int[]{3,2,1,2};
			System.out.println();
			WaterDrop x = new WaterDrop();
			int[] res = x.getMap(terrian, 1, 2);
			print(res);
		}
		
		private static void print(int[] terrian) {
			List<String> str = new ArrayList<>();
			int max = 0;
			String seaLevel = "";
			for(int x : terrian) {
				seaLevel += "*";
				max = Math.max(x, max);
			}
			str.add(seaLevel);
			while(max > 0) {
				String cur = "";
				for(int i = 0 ; i < terrian.length; i++) {
					if(terrian[i] > 0) {
						cur += "*";
						terrian[i]--;
					} else {
						cur += " ";
					}
				}
				str.add(cur);
				max--;
			}
			for(int i = str.size() - 1 ; i >= 0; i--) {
				System.out.println(str.get(i));
			}
		}
}
