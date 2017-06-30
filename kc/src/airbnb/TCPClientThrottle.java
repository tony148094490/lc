package airbnb;
import java.io.*;
import java.net.*;
// https://tinyurl.com/y9jdorkf
// https://docs.oracle.com/javase/tutorial/networking/sockets/
/**
 * http://www.1point3acres.com/bbs/thread-212911-1-1.html
 * http://www.1point3acres.com/bbs/thread-165457-1-1.html
 *
写echo TCP client， 向面试官的server发请求， 读回数据。
地里比较少人说这种， 我来详细说一下， 情境是这样的： 想象你开车， 
踩下油门，车会加速，放开油门，车会减速。 client向server发的请求有以下2种： 
（a）STATUS --表示查询现在车的速度和踩下踏板的压力； 
（b）THROTTLE 50.1 --- 这条指令是“THROTTLE” 加上一个数字， 表示我现在将踩油门的压力调为50.1


EXAMPLE: 比如在telnet中
STATUS
0.0 0.0     (这行是server返回的， 第一个数字表示压力，第二个数字表示速度)  
THROTTLE 50.1 (这个指令发出 server没有返回).
STATUS
50.1 3.75   (可以看到速度在缓慢上升)
STATUS     (过几秒后，你又发STATUS指令过去).
50.1 15.98   (速度依旧上升。。。)

对就是这样，像是简单物理实验。

写完TCP client后，要求是写一个方法将速度控制到达一个target speed


probably more detailed analysis before coding
 *
 */
public class TCPClientThrottle {
	
	// basic one-off connection
	public static void main(String[] args) throws InterruptedException {
		int target = Integer.parseInt(args[0]);
		double lowerBoundThrottle = 0;
		double upperBoundThrottle = 200;
		
		try {
			// Try to establish connection to server
			Socket client = new Socket("localhost", 6603);
			int counter = 0;
			while(true){
				// establish outgoing message.
				DataOutputStream out = new DataOutputStream(client.getOutputStream());
	
				out.writeUTF("STATUS");
				
				DataInputStream in = new DataInputStream(client.getInputStream());
				
				// parse result
				String res = in.readUTF();
				System.out.println("Current Status is: " + res + ", target is " + target);
				
				String[] parts = res.split(" ");
				double throttle = Double.parseDouble(parts[0]);
				double speed = Double.parseDouble(parts[1]);
				
				if(speed > target) {
					upperBoundThrottle = throttle;
					String instruction = "THROTTLE " + String.valueOf(lowerBoundThrottle + (upperBoundThrottle - lowerBoundThrottle)/2);
					out.writeUTF(instruction);
				} else if(speed == target) {
					counter++;
					if(counter == 10)
					break;
				} else {
					upperBoundThrottle = 200;
					out.writeUTF("THROTTLE " + upperBoundThrottle);
				}
				
				Thread.sleep(1000);
			}
			client.close();
		} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
