package kc;

public class ReadWriteLock {
	int readers = 0;
	int writers = 0;
	int writeRequests = 0;
	
	public synchronized void lockRead() throws InterruptedException {
		while(writers > 0 || writeRequests > 0) {
			wait();
		}
		System.out.println("Read lock occurred " + Thread.currentThread());
		readers++;
	}
	
	public synchronized void unlockRead() {
		readers--;
		notifyAll();
		System.out.println("Read unlock occurred " + Thread.currentThread());

	}
	
	public synchronized void lockWrite() throws InterruptedException {
		writeRequests++;
		while(readers > 0 || writers > 0) {
			wait();
		}
		writers++;
		writeRequests--;
		System.out.println("Write lock occurred " + Thread.currentThread());
	}
	
	public synchronized void unlockWrite() {
		writers--;
		notifyAll();
		System.out.println("Write unlock occurred " + Thread.currentThread());

	}
}
