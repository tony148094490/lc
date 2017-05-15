package kc;

public class ReadNCharactersGivenRead4II {
    char[] mem = new char[4];
    int memStart = 0;
    int memEnd = 0;
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
    	
    	//try re-loading if it's at the end or at the beginning
        if(memEnd == 0) {
            memEnd = read4(mem);
            memStart = 0;
        }
        
        if(memEnd == 0) return 0;
        
        if(memStart == memEnd) return 0;
        
        
        for(int i = 0; i < n; i++) {
            buf[i] = mem[memStart];
            memStart++;
            if(memStart == memEnd) {
                if(memEnd <= 3) return i+1;
                memEnd = read4(mem);
                memStart = 0;
                if(memEnd == 0) return i+1;
            }
        }
        return n;
    }
    
	public int read4(char[] buf) {
		if(buf.length >= 4) {
			return 4;
		} else {
			return buf.length;
		}
	}
}
