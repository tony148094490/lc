package kc;

public class ReadNCharactersGivenRead4II {
    private char[] buffer = new char[4];
    private int index = 0;
    private int progress = 0;
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int res = 0;
        while(res < n) {
            if(progress == 0) {
                index = this.read4(buffer);
            }
            
            if(index == 0) {
                return res;
            }
            
            while(progress < index && res < n) {
                buf[res] = buffer[progress];
                progress++;
                res++;
            }
            
            if(progress == index) progress = 0;
        }
        return res;
    }
    
	public int read4(char[] buf) {
		if(buf.length >= 4) {
			return 4;
		} else {
			return buf.length;
		}
	}
}
