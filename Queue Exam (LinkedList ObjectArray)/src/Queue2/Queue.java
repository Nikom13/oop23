package Queue2;

import java.util.Arrays;

/**
 * @invar | toArray() != null
 * @invar | Arrays.stream(toArray()).allMatch(q -> q != null)
 * 
 */

public abstract class Queue {
	
	//Invars
	

	
	
	
	
	///Constructor
	
	public Queue() {}
	
	
	
	//Getters
	


	
	
	//Setters
	
	
	
	//Methods
	
	/**
	 * 
	 * @inspects | this
	 * @post | result == toArray().length
	 * 
	 * 
	 */
	public abstract int size();
	
	
	/**
	 * @inspects | this
	 * 
	 * @creates | result
	 * 
	 */
	public abstract Object[] toArray();
	
	
	/**
	 * Adding element
	 * 
	 * @pre | element != null
	 * 
	 * @mutates | this
	 * 
	 * 
	 * 
	 * @post | size() == old(size()) + 1
	 * @post | toArray()[old(size())] == element
	 * 	 
	 */
	public abstract void enqueue(Object element);
	
	/**
	 * removing first element and returning it back
	 * 
	 * 
	 * @pre | size() > 0 
	 * @mutates | this
	 * 
	 * @post | size() == old(size()) - 1
	 * 
	 * @post | result == toArray()[0]
	 * 
	 */
	public abstract Object dequeue();
	

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public abstract boolean equals(Queue other);
	
	
}
