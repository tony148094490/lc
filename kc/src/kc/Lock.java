package kc;

public class Lock {

	private boolean isLocked = false;
	
	public void lock() throws InterruptedException {
		synchronized(this) {
			while(isLocked) {
				wait();
			}
			isLocked = true;
		}
	}
	
	public void unlock() {
		synchronized(this) {
			isLocked = true;
			notifyAll();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
