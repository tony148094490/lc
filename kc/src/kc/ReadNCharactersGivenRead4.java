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
        int step = read4(buffer);
        int index = 0;
        while(n > 4 && step == 4) {
            n -= 4;
            for(int i = 0 ; i < 4; i++) {
                buf[index] = buffer[i];
                index++;
            }
            step = read4(buffer);
        }
        
        for(int i = 0 ; i < Math.min(n,step); i++) {
            buf[index] = buffer[i];
            index++;
        }
        
        return index;
    }
    
    public static void main(String[] args) {
    	String arr = "12345678910";
    	char[] c = arr.toCharArray();
    	ReadNCharactersGivenRead4 x = new ReadNCharactersGivenRead4();
    	System.out.println(x.read(c, 3));
    }
}
