package kc;

public class FlipGameII {
    public boolean canWin(String s) {
        return canWin(s.toCharArray());
    }
    
    private boolean canWin(char[] s) {
    	// exhaust all possible places and recalculate the chances of opponent winning the game.
    	for(int i = 0 ; i < s.length - 1; i++) {
    		if(s[i] == '+' && s[i+1] == '+') {
    			s[i] = '-';
    			s[i+1] = '-';
    			boolean opponentCanWin = canWin(s);
    			
    			// add these back before returning result to keep the order intact
    			s[i] = '+';
    			s[i+1] = '+';
    			
    			// if opponent cannot win if we place there
    			if(!opponentCanWin) return true;
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
		String s2 = "+++++++++";
		FlipGameII x = new FlipGameII();
		System.out.println(x.canWin(s2));
	}
}
