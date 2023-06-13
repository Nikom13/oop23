package Queue2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SimpleQueue extends Queue{
	
	
	/**
	 * @invar | queues != null
	 * @invar | queues.stream().allMatch(q -> q != null)
	 * 
	 */
	private LinkedList<Object> queues = new LinkedList<>();
	
		
//	/**
//	 * 
//	 * @represenationObject
//	 * 
//	 */
//	public List<Object> getQueues() {
//		return queues;
//	}

	/**
	 * @post | size() == 0
	 * 
	 */
	public SimpleQueue() {
	}

	@Override
	public int size() {
		return queues.size();
	}

	@Override
	public Object[] toArray() {
		return queues.toArray();
	}

	@Override
	public void enqueue(Object element) {
		queues.add(element);
	}

	@Override
	public Object dequeue() {
		return queues.removeFirst();
		
	}

	@Override
	public boolean equals(Queue other) {
		return other instanceof SimpleQueue && Arrays.equals(toArray(), other.toArray());
	}

	
	
}
