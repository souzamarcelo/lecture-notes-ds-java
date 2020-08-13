package linear.deque;

public class ArrayDeque<E> implements Deque<E> {
	public static final int CAPACITY = 1000;
	private E[] data;
	private int f = 0;
	private int sz = 0;
	
	public ArrayDeque() {this(CAPACITY);}
	
	public ArrayDeque(int capacity) {
		data = (E[]) new Object[capacity];
	}
	
	public int size() { return sz; }
	public boolean isEmpty() { return (sz == 0); }
	
	public E first() {
		if (isEmpty()) return null;
		return data[f];
	}
	
	public E last() {
		if (isEmpty()) return null;
		int index = f + sz - 1;
		if(index >= data.length)
			index -= data.length;
		return data[index];
	}

	public void addFirst(E e) {
		if (sz == data.length) 
			throw new IllegalStateException("Queue is full");
		
		int avail = f - 1;
		if(avail < 0)
			avail = data.length - 1;
		
		data[avail] = e;
		f = avail;
		sz++;
	}

	public void addLast(E e) {
		if (sz == data.length) 
			throw new IllegalStateException("Queue is full");
		
		int avail = f + sz;
		if(avail >= data.length)
			avail -= data.length;
		
		data[avail] = e;
		sz++;
	}

	public E removeFirst() {
		if (isEmpty()) return null;
		E answer = data[f];
		data[f] = null;
		
		f = f + 1;
		if(f >= data.length) f = 0;
		
		sz--;
		return answer;
	}
	
	public E removeLast() {
		if (isEmpty()) return null;
		int index = f + sz - 1;
		if(index >= data.length) index -= data.length;
		
		E answer = data[index];
		data[index] = null;
		
		sz--;
		return answer;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		int k = f;
		for (int j=0; j < sz; j++) {
			if (j > 0)
				sb.append(", ");
			sb.append(data[k]);
			k = (k + 1) % data.length;
		}
		sb.append(")");
		return sb.toString();
	}
}