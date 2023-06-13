package Queue2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RingBuffer extends Queue {

	
	
	private Object[] buffer = new Object[3];
	private int size;
	private int start;
	private int end;
	

	
	public RingBuffer(){}
	
	
	public Object[] toArray() {
		Object[] array = new Object[size];
		
		if (start + size <= buffer.length ) {
			System.arraycopy(buffer, start, array, 0, size);
		}else {
			int SizeNewArrayStart = buffer.length - start;
			System.arraycopy(buffer, start, array, 0, SizeNewArrayStart); ///new array with null before the start pos
			System.arraycopy(buffer, 0, array, SizeNewArrayStart, size - SizeNewArrayStart); //no idea
			
			


		}
		
		return array;
		
		
	}

	
	
	@Override
	public int size() {
		return size;
	}

	}

	@Override
	public void enqueue(Object element) {

		if(buffer.length == size) {
			buffer = Arrays.copyOf(toArray(), size * 2);
			start = 0;
			
		}
		
		buffer[(start + size++) % buffer.length] = element; //no idea but it gives the right index
			
			
	}

	@Override
	public Object dequeue() {
		Object result =  buffer[start];
		buffer[start] = null;
		start = (start + 1) % buffer.length;
		size--;
		return result;
		
		
		
		
	}

	@Override
	public boolean equals(Queue other) {
		return other instanceof RingBuffer && Arrays.equals(toArray(), other.toArray());
	}
	
	
	
	
	
}
