package kc;

public class Semaphore {
	int signal = 0;
	int bound = 0;
	
	public Semaphore(int bound) {
		this.bound = bound;
	}
	
	public synchronized void take() throws InterruptedException {
		while(signal == bound) wait();
		signal++;
		notify();
	}
	
	public synchronized void release() throws InterruptedException {
		while(signal == 0) wait();
		signal--;
		notify();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(10);
		
		// Sender 
		SendingThread st = semaphore.new SendingThread();
		st.send(semaphore);
		
		// Receiver
		ReceivingThread rt = semaphore.new ReceivingThread();
		rt.receive(semaphore);
	}


	public class SendingThread {
		public void send(Semaphore semaphore) throws InterruptedException {
			semaphore.take();
			// send a single message
		}
	}

	public class ReceivingThread {
		public void receive(Semaphore semaphore) throws InterruptedException {
			semaphore.release();
			// receive/poll a single message
		}
	}
}
