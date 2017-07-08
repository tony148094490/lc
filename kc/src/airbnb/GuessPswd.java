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

	
	public int guess(int port, String hostId) throws Exception {
		int[] res = new int[4];
		int[] mask = {1000, 100, 10, 1};

		int hit = 0;

		for(int i = 1; i <= 6 && hit < 4; i++) {
			int totalForThisDigit = getAnswer(i * 1111, port, hostId);
			int j = 0;
			while(j < 4 && totalForThisDigit > 0) {
				if(res[j] != 0) continue;
				int newTry = mask[j] * i;
				int newAnswer = getAnswer(newTry, port, hostId);
				if(newAnswer != 0) {
					res[j] = i;
					totalForThisDigit--;
					hit++;
					if(hit == 4) break;
				}
				j++;
			}
		}

		int answer = 0;
		for(int i = 0 ; i < mask.length;i++) {
			answer += mask[i] * res[i];
		}
		return answer;
	}

	private int getAnswer(int nr, int port, String hostId) throws IOException {
		Socket socket = new Socket();
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeInt(nr);
		DataInputStream input = new DataInputStream(socket.getInputStream());
		int res = input.readInt();
		socket.close();
		return res;
	}
}
