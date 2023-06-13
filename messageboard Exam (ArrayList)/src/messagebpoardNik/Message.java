package messagebpoardNik;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import logicalcollections.LogicalList;
//LOGICAL LISTS DO NOT WORK WHY



/**
 *Come back for specifications
 * 
 * getAuthor() != null
 * getReplies() != null
 * getReplies().stream().allMatch(r -> r != null && !reply.isDeleted())
 *
 */
public class Message {

	/**
	 * @invar | author != null
	 * @invar | replies != null
	 * @invar | replies.stream().allMatch(r -> r != null)
//	 * @invar | LogicalList.distinct(replies)
	 */
	private String author;
	
	/**
	 * @represenationObject
	 */	
	private List<Reply> replies = new ArrayList<>();
	
	
	private boolean isDeleted;
	
	
	//// Internal
	
	
	/**
	 * Allows us to use this in other classes
	 * Why do we need internal? Not sure
	 * 
	 * Author cannot be null because not an object
	 * 
	 * @post | result != null
	 * 
	 * Why result cannot be null? Not sure
	 * 
	 * 
	 */
	String getAuthorInternal() { return author;}
	
	/**
	 * Why this one has bi-directional relatioship?
	 * 
	 * @creates | result
	 * @post | result.stream().allMatch(r -> r != null)
//	 * @post | LogicalList.distinct(result)
	 * @peerObjects
	 * 
	 */
	List<Reply> getRepliesInternal(){
		return List.copyOf(replies);
	}
	

	boolean isDeletedInternal() {
		return isDeleted;
	}
	
	//// Now not internal 
	
	/**
	 * 
	 */
	public String getAuthor() {
		return getAuthorInternal();
	}
	
	
	/**
	 * @creates | result
	 * @peerObjects
	 */
	public List<Reply> getReplies() {
		return getRepliesInternal();
		
	}
	
	public boolean isDeleted() {
		return isDeletedInternal();
	}
	
	
	///Now constructor
	
	/**
	 * Constructor = should be accesible by other packages
	 * 
	 * @throws IllegalArgumentException | author == null
	 * 
	 * Now since we are workign with constructor, use methods to check 
	 * Why internal? No idea. 
	 * 
	 * @post | getAuthor() == author
	 * @post | getReplies().isEmpty()
	 * isEmpty is a List internal method
	 * 
	 * @post | !isDeleted() 
	 * 
	 * 
	 */
	public Message(String author) {
		
		if (author == null ) {
			throw new IllegalArgumentException("author is null");
		} //throw NEW
		this.author = author;
		
	}
	
	
	///Now methods that functional getters, the ones that are used by pther packages

	 
	/**
	 * @pre | reply != null
	 * @pre | !getRepliesInternal().contains(reply)
	 * 
	 * @mutates_properties | getRepliesInternal()
	 * 
//	 * @post | getRepliesInternal().equals(LogicalList.plus(old(getRepliesInternal()), reply))
	 * 
	 */
	void addReply(Reply reply) {
		replies.add(reply);
		
		//FUNCTION OF LIST
	}
	
	
	/**
	 * 
	 * @pre | reply != null
	 * @pre | getRepliesInternal().contains(reply)
	 * 
//	 * @post | getRepliesInternal().equals(LogicalList.minus(old(getRepliesInternal()), reply))
	 * 
	 * 
	 */
	void removeReply(Reply reply) {
		replies.remove(reply);
		
		//Function of LIST
	}

	
	/**
	 * 
	 * @pre | !isDeleted()
	 * 
	 * @mutates | this
	 * @post | isDeleted()
	 * 
	 * 
	 */
	public void delete() {
		isDeleted = true;
	}
	
	
	
	/**
	 * 
	 * 
	 * 
	 */
	public boolean isIsomorphic(Message other) {
		return author.equals(other.author) && isDeleted == other.isDeleted;
	}
	
	//Wrong implementation by me
//	public boolean isomorphic(Message message) {
//		if ( this.getAuthor().equals(message.getAuthor()) && 
//				this.isDeleted().equals(message.isDeleted()) &&
//				this.getClass().equals(message.getClass()));
//		return false;
//	}
	
	
//	public Message create(String author) {
//		return new Message(author);
//	}



	
	
	
	


	
	
	
	
	
	
}
