package messagebpoardNik;
import logicalcollections.LogicalList;


/**
 * 
 * @invar | getParent() != null
 * 
 * Or if the parent message has been deleted or is in the replies
 * @invar | isDeleted() || getParent().getReplies().contains(this)
 * 
 *
 */

public class Reply extends Message{
	
	/**
	 * Why FINAL?
	 * @invar | parent != null
	 * 
	 */
	final Message parent;
	
	
	
	//INTERNAL
	
	Message getParentInternal() {
		return parent;
	}
	
	
	//EXTERNAL
	
	public Message getParent() {
		return getParentInternal();
	}


	/**
	 * @throws IllegalArgumentException | author == null
	 * @throws IllegalArgumentException | parent == null
	 * 
	 * 
	 * @mutates_properties | parent.getReplies()
	 * 
	 * @post | getAuthor() == author
	 * @post | getReplies().isEmpty() 
	 * @post | !isDeleted()
	 * 
//	 * @post | parent.getReplies().equals(LogicalList.plus(old(parent.getReplies()), this))
	 */
	public Reply(String author, Message parent) {
		super(author);
		this.parent= parent;
		parent.addReply(this);
	}
	
	
	/**
	 * 
	 * All external should be public 
//	 * @post | getParent().getReplies().equals(LogicalList.minus(old(parent.getReplies()), this))
	 */
	@Override
	public void delete() {
		super.delete();
		parent.removeReply(this);
	}


	@Override
	public boolean isIsomorphic(Message other) {
		return super.isIsomorphic(other) && other instanceof Reply;
	}
	
	
	
	
	

}
