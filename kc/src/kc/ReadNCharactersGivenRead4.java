package kc;

public class ReadNCharactersGivenRead4 {
	public int read4(char[] buf) {
		if(buf.length >= 4) {
			return 4;
		} else {
			return buf.length;
		}
	}
	
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int res = 0;
        int cur = 0;
        int thisRun = 4;
        while(n >= 4 && thisRun == 4) {
            thisRun = this.read4(buffer);
            for(int i = 0; i < thisRun; i++) {
                buf[cur] = buffer[i];
                cur++;
            }
            n -= 4;
            res += thisRun;
        }
        
        if(thisRun != 4) {
            return res;
        } else {
            int needed = Math.min(n, this.read4(buffer));
            for(int i = 0; i < needed; i++) {
                buf[cur] = buffer[i];
                cur++;
            }
            res += needed;
            return res;
        }
    }
    
    public static void main(String[] args) {
    	String arr = "12345678910";
    	char[] c = arr.toCharArray();
    	ReadNCharactersGivenRead4 x = new ReadNCharactersGivenRead4();
    	System.out.println(x.read(c, 3));
    }
}
