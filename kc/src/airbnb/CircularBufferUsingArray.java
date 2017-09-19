package airbnb;

// http://preview.tinyurl.com/y75nuozk
// use linkedlist or array
// http://www.1point3acres.com/bbs/thread-191081-1-1.html
// very messy impl, hope you can get a cleaner one
public class CircularBufferUsingArray<T> {
	
	T[] buffer;
	Integer head = null; // the current head
	Integer tail = null; // the last poped position
	int curSize = 0; // current valid length
	Semaphore semaphore;// used for locking 
	
	@SuppressWarnings("unchecked")
	public CircularBufferUsingArray(int size, Semaphore sema) {
		buffer = (T[]) new Object[size];
		semaphore = sema;
	}

	public void add(T toAdd) throws Exception {

		if(curSize == buffer.length) throw new Exception();

		if(head == null) {
			head = 0;
			buffer[head] = toAdd;
		} else {
			head++;
			head %= buffer.length;
			buffer[head] = toAdd;
		}
		
		curSize++;
	}

	public T get() throws Exception {
		
		if(curSize == 0) throw new Exception();
		
		if(tail == null) {
			tail = (tail + 1) % buffer.length;
			curSize--;
			return buffer[0];
		} else {
			T res = buffer[tail];
			tail++;
			tail %= buffer.length;
			curSize--;
			return res;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Semaphore se = new Semaphore(1);
		CircularBufferUsingArray<Integer> buffer = new CircularBufferUsingArray<Integer>(5, se);
		for(int i = 0 ; i < 10; i++) {
			System.out.println("Adding " + i);
			buffer.add(i);
			System.out.println("Getting " + buffer.get());
		}

	}
	
	public static class Semaphore {
		int signal = 0;
		int bound = 0;
		
		public Semaphore(int b) {
			bound = b;
		}
		
		public synchronized void take() throws InterruptedException {
			while(signal == bound) wait();
			signal++;
			notifyAll();
		}
		
		public synchronized void release() throws InterruptedException {
			while(signal == 0) wait();
			signal--;
			notifyAll();
		}
	}
}
