package airbnb;

// http://preview.tinyurl.com/y75nuozk
// use linkedlist or array
// http://www.1point3acres.com/bbs/thread-191081-1-1.html
public class CircularBufferUsingArray<T> {
	
	private T[] buffer;
	private Integer tail = null;
	private Integer head = null;
	private Semaphore semaphore;
	
	@SuppressWarnings("unchecked")
	public CircularBufferUsingArray(int size, Semaphore s) {
		buffer = (T[]) new Object[size];
		semaphore = s;
	}
	
	public void add(T toAdd) throws Exception {
		semaphore.take();
		if(head == null) {
			head = 0;
			buffer[head] = toAdd;
		} else if (tail == null && head == buffer.length - 1){
			throw new Exception("Buffer full");
		} else if((head + 1) % buffer.length == tail) {
			throw new Exception("Buffer full");
		} else {
			head = (head + 1) % buffer.length;
			buffer[head] = toAdd;
		}
		semaphore.release();
	}
	
	public T get() throws Exception {
		semaphore.take();
		if(tail == null) {
			tail = 0;
			T res =  buffer[tail];
			semaphore.release();
			return res;
		} else {
			if(tail == head) {
				throw new Exception("Not enough items in buffer!");
			} else {
				tail = (tail + 1) % buffer.length;
				T res = buffer[tail];
				semaphore.release();
				return res;
			}
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
