package airbnb;
// https://tinyurl.com/y96kjs76
// http://www.1point3acres.com/bbs/thread-146537-1-1.html
// needs to get familar with the transformation from last iteration to current
// https://www.fractalus.com/kerry/tutorials/hilbert/hilbert-tutorial.html
// essentially top left and right stay the same shape, bottom left and right rotate
// the actual number will need to come from the previous iteration
public class HibertCurve {

		public long hilbertCurve2(long x, long y, int iteration) {
			if(iteration == 0) return 1;
			long quadrantUpperLimit = 1 << (iteration - 1);
			long prevIterationMax = 1 << (2 * (iteration - 1)); // it's not a square, it's a shape so the range calculation is kind of different
			
			// four quadrants
			if(x < quadrantUpperLimit && y < quadrantUpperLimit) {
				// bottom left: from last iteration to this iteration, clock wise rotate and flip, which is diagonal axis flip
				return hilbertCurve2(y,x,iteration-1);
				
			} else if (x < quadrantUpperLimit && y >= quadrantUpperLimit) {
				// top left: from last iteration to this iteration, no change except for adding the previous 1 shape-worth of numbers. 
				return prevIterationMax + hilbertCurve2(x, y - quadrantUpperLimit, iteration - 1);
				
			} else if (x >= quadrantUpperLimit && y >= quadrantUpperLimit) {
				// top right: from last iteration to this iteration, no change except for adding the previous 2 shape-worth of numbers.
				return 2 * prevIterationMax + hilbertCurve2(x-quadrantUpperLimit, y-quadrantUpperLimit, iteration-1);
				
			} else {
				// bottom right: from last iteration to this iteration, anti clock rotation and flip (which is anti-diagonal axis flip) and plus the previous 3 shape-worth of numbers.
				return 3 * prevIterationMax + hilbertCurve2(quadrantUpperLimit-1- y, quadrantUpperLimit-1 - (x-quadrantUpperLimit), iteration - 1); // this conversion is a little hard to understand
				
			}
		}
		
	    public static int hilbertCurve(int x, int y, int iter) {
	        if (iter == 0) return 1;
	        int len = 1 << (iter - 1); // side edge that can cuts quadrant 1 and 2, 3 and 4.
	        int num = 1 << (2 * (iter - 1)); // sum of prev iterations

	        if (x >= len && y >= len) {
	            // 3 Shape is identical with previous iteration
	            return 2 * num + hilbertCurve(x - len, y - len, iter - 1);
	        } else if (x < len && y >= len) {
	            // 2 Shape is identical with previous iteration
	            return num + hilbertCurve(x, y - len, iter - 1);
	        } else if (x < len && y < len) {
	            // 1 Clock-wise rotate 90
	            return hilbertCurve(y, x, iter - 1);
	        } else {
	            // 4 Anti-Clockwise rotate 90
	            return 3 * num + hilbertCurve(len - 1 - y, len - 1 - (x - len), iter - 1);
	        }
	    }
	    
	    
	    public static void main(String[] args) {
	    	HibertCurve h = new HibertCurve();
	        System.out.println(hilbertCurve(1,1,3) + ", " + h.hilbertCurve2(1L, 1L, 4));
	        System.out.println(hilbertCurve(2,2,4) + ", " + h.hilbertCurve2(2L, 2L, 4));
	        System.out.println(hilbertCurve(1,3,4) + ", " + h.hilbertCurve2(1L, 3L, 4));
	        System.out.println(hilbertCurve(2,0,4) + ", " + h.hilbertCurve2(2L, 0L, 4));
	        System.out.println(hilbertCurve(4,1,4) + ", " + h.hilbertCurve2(4L, 1L, 4));
	        System.out.println(hilbertCurve(4,2,4) +  ", " + h.hilbertCurve2(4L, 2L, 4));
	        System.out.println(hilbertCurve(4,5,4) +  ", " + h.hilbertCurve2(4L, 5L, 4));
	    	System.out.println(hilbertCurve(4,0,3) + ", " +  h.hilbertCurve2(4L, 0L, 3)); 


		}
}
