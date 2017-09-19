package kc;

public class Read4K {
    char[] buffer = new char[4];
    int progress = 0;
    int count = 0;
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if(n == 0) return 0;
        
        if(progress == 4 || count == 0) {
            count = read4(buffer);
            progress = 0;
        }
        
        if(count == 0) return 0;
        
        if(count < 4 && progress == count) return 0;

        int index = 0;
        while(index < n) {
            buf[index] = buffer[progress];
            progress++;
            index++;
            if(progress < 4 && progress == count) return index;
                
            if(progress == 4) {
                progress = 0;
                count = read4(buffer);
                if(count == 0) return index;
            }
        }
        return index;
    }
    
    private int read4(char[] buf) {
    	return 0;
    }
}
