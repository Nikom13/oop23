package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class SimpleQueue extends Queue {


	/**
	 * @invar | elements != null
	 * @invar | elements.stream().allMatch( e -> e != null)
	 * 
	 * @representationObject
	 */
	private LinkedList<Object> elements = new LinkedList<>();
//	private ArrayList<Object> elements = new ArrayList<>();
	
	
	public int size() {
		return elements.size();
	}

	@Override
	public Object[] toArray() {
		return elements.toArray();
	}

	@Override
	public void enqueue(Object element) {
		elements.add(element);
	}

	@Override
	public Object dequeue() {
//		return elements.remove(0);
		return elements.removeFirst();
	}
	
	
	/**
	 * @post | size() == 0
	 */
	//Constructor
	public SimpleQueue() {}

	
	

	

}
