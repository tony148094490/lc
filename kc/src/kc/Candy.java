package kc;

public class Candy {
    public int candy(int[] ratings) {
        if(ratings.length < 2) return ratings.length;
    	int[] c = new int[ratings.length];
        int i = 0;
        while( i < ratings.length - 1) {
        	if(ratings[i] < ratings[i+1]) {
        		c[i] = 1;
        		i++;
        		while(i<ratings.length && ratings[i-1] < ratings[i]) {
        			c[i] = c[i-1] + 1;
        			i++;
        		}
        		i--;
        	} else if(ratings[i] > ratings[i+1]) {
        		i++;
        		int k = i;
        		while(i<ratings.length && ratings[i-1] > ratings[i]) {
        			i++;
        		}
        		k = i - 1;
        		c[k] = 1;
        		k--;
        		while(k >= 0 && ratings[k] > ratings[k+1]) {       			
        			c[k] = Math.max(c[k],c[k+1] + 1);
        			k--;
        		}
        		i--;
        	} else {
        		if(c[i] == 0) {
        			c[i] = 1;
        			c[i+1] = 1;
        		} else {
        			c[i+1] = 1;
        		}
        		i++;
        	}
        }
        
        int res = 0;
        for(Integer x : c) {System.out.println(x);
        	res += x;
        }
        return res;
    }
    
    public static void main(String[] args) {
		int[] arr = {4,2,3,4,1};
		Candy x = new Candy();
		System.out.println(x.candy(arr));
	}
}
