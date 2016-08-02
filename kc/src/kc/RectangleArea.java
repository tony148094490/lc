package kc;

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
       int total = ((C - A) * (D - B)) + ((H - F) * (G - E));
       if(A >= G || C <= E || B >= H || D <= F) {
    	   return total;
       } 
    	
       int x = 0;
       int y = 0;
       
       if(A <= E ) {
    	   if(G >= C) {
    		   x = C - E;
    	   } else {
    		   x = G - E;
    	   }
       } else {
    	   if(C >= G) {
    		   x = G - A;
    	   } else {
    		   x = C - A;
    	   }
       }
       
       
       if(B >= F) {
    	   if(D >= H) {
    		   y = H - B;
    	   } else {
    		   y = D - B;
    	   }
       } else {
    	   if( D >= H ) {
    		   y = H - F;
    	   } else {
    		   y = D - F;
    	   }
       }
       
       return total - (y*x);
    }
}
