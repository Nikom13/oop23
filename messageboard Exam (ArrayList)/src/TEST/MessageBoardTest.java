package TEST;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;


import logicalcollections.LogicalList;
import messagebpoardNik.OM;
import messagebpoardNik.Reply;

import org.junit.jupiter.api.Test;

//LOGICAL COLLECTIONS DO NOT WORK WITH TESTS!!!!

class MessageBoardTest {

	@Test
	void test() {
		OM om = new OM("Author1");
		assertEquals("Author1", om.getAuthor());
		assertFalse(om.isDeleted());
		assertTrue(om.getReplies().isEmpty());
		
		
		Reply reply1 = new Reply("Author2", om);
		assertEquals("Author2", reply1.getAuthor());
		assertFalse(reply1.isDeleted());
		assertFalse(om.getReplies().isEmpty());	
		//NEW --> function of LIST
		assertEquals(List.of(reply1), om.getReplies());
		
		
		Reply reply2 = new Reply("Author2", om);
		//NEW
		assertEquals(List.of(reply1, reply2), om.getReplies());
		
		
		OM om2 = new OM("Author1");
		assertTrue(om2.isIsomorphic(om));
		assertTrue(reply1.isIsomorphic(reply2));
		assertFalse(reply1.isIsomorphic(om));
		
		reply1.delete();
		assertTrue(reply1.isDeleted());
		assertEquals(List.of(reply2), om.getReplies());
		assertFalse(reply1.isIsomorphic(reply2));
		
		om.delete();
		assertTrue(om.isDeleted());
		
	}

}
