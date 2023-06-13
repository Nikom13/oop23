package messagebpoardNik;

import java.util.List;


public class OM extends Message {

	
	
	/**
	 * @throws IllegalArgumentException | author == null
	 * 
	 * 
	 * @post | getAuthor() == author
	 * @post | getReplies().isEmpty() 
	 * @post | !isDeleted()
	 * 
	 *
	 */
	public OM(String author) {
		super(author);
	}
	

	@Override
	public void delete() {
		super.delete();
	}

	@Override
	public boolean isIsomorphic(Message other) {
		return super.isIsomorphic(other) && other instanceof OM;
	}
	
	
	
	

	
}
