package airbnb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=281246
// http://www.1point3acres.com/bbs/thread-189016-1-1.html

// 連接到關主的TCP/IP Server, 猜四碼數字(1111~6666). 全猜對會回傳4a0b, 對兩個數字兩個位置會回傳2a2b....etc. 盡量用最少 calls to the server to solve the answer.

public class GuessPswd {

	
	public int guess(int port, String hostId) throws UnknownHostException, IOException {
		int[] multiplier = {1000, 100, 10, 1};
		int[] res = new int[4];
		
		int hit = 0;
		int base = 1;
		while(hit < 4) {
			int tempRes = getAnswer(base * 1111, port, hostId);
			int j = 0;
			while(j < 4 && tempRes > 0) {
				if(res[j] != 0) {
					j++;
					continue;
				}
				int singleDigitGuess = multiplier[j] * base;
				if (getAnswer(singleDigitGuess, port, hostId) != 0) {
					res[j] = base;
					tempRes--;
					hit++;
				}
				j++;
			}
			base++;
		}
		
		int sum = 0;
		for(int i = 0 ; i < multiplier.length; i++) sum += (res[i] * multiplier[i]);
		return sum;
	}
	
	private int getAnswer(int nr, int port, String hostId) throws UnknownHostException, IOException {
		Socket socket = new Socket(hostId, port);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeInt(nr);
		DataInputStream in = new DataInputStream(socket.getInputStream());
		int res = in.readInt();
		socket.close();
		return res;
	}
}
