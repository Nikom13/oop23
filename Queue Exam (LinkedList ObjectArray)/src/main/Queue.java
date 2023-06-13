package main;

import java.util.Arrays;



//Answers: https://github.com/btj/queues/tree/main/queues/src/queues

//Furthermore, develop a class Queue that generalizes over 
//arbitrary implementations of the queue abstraction, 
//including your SimpleQueue implementation.


/**
 * 
 * 
 *
 * @invar | toArray() != null
 * @invar | Arrays.stream(toArray()).allMatch(e -> e != null)
 */
public abstract class Queue {
	

	/**
	 * @inspect | this
	 * @post | result == toArray().length
	 */
	//return size
	public abstract int size();
	
	
	//return array
	/**
	 * @inspects | this
	 * @creates | result
	 */
	public abstract Object[] toArray();
	
	
	// add element to the end of the array

	/**
	 * @throws IllegalArgumentException | element == null
	 * 
	 * @mutates | this
	 * @post | size() == old(size()) + 1
	 * @post | toArray()[old(size())] == element
	 * 
	 *  
	 */
	public abstract void enqueue(Object element);
	
	
	/**
	 * @pre | size() > 0
	 * @mutates | this
	 * @post | size() == old(size()) - 1
	 * @post | result == old(toArray())[0]
	 * 
	 */
	//remove element from the front of the array and return the name of it
	public abstract Object dequeue();
	
	
	
	
}
