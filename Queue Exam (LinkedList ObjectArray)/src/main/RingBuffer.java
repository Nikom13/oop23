package main;

import java.util.Arrays;

//A ring buffer is a data structure that supports an 
//efficient implementation of the queue abstraction. 
//It stores the queue’s sequence of elements in an array, 
//but it does not necessarily store the first element of 
//the sequence at index 0. It keeps a variable start that 
//records the index of the first element of the sequence (if any), 
//and a variable size that records the number of elements in the 
//queue. The length of the array may be greater than the number
//of elements stored; any excess capacity allows new elements 
//to be added efficiently.


public class RingBuffer extends Queue{
	
	/**
	 * Constructor
	 * 
	 * post | size() == 0
	 * 
	 */
	public RingBuffer() {
	}
	
	/*
	 * @invar | 0 <= start
	 * @invar | start < elements.length   //why??
	 * @invar | 0 <= size
	 * @invar | size <= elements.length
	 * 
	 * @respresentationObject
	 */
	private Object[] elements = new Object[3];
	private int size;
	private int start;
	private int end;

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		
		Object[] result = new Object[size]; //okay, we made it the same size 
		
		if (start + size <= elements.length) {
			System.arraycopy(elements, start, result, 0, size);
		} else {
			int sizeFirstPart = elements.length - start;
			System.arraycopy(elements, start, result, 0, sizeFirstPart);
			System.arraycopy(elements, 0, result, sizeFirstPart, size - sizeFirstPart);

		}
		
		
		
		
		return result;
	}

	@Override
	public void enqueue(Object element) {
		
		if (elements.length == size) {
			elements = Arrays.copyOf(toArray(), size * 2);
			start = 0; //why we need to decode start?
		}
		
		elements[(start + size++) % elements.length] = element; 
		
	}

	@Override
	public Object dequeue() {
		Object result = elements[start];
		elements[start] = null;
		start = (start + 1) % elements.length;
		size--;
		return result;
	}

	
	
	
}
