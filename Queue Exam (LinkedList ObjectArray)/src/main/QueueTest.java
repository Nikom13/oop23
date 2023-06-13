package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
	
	
//	private ArrayList<Object> array1 = new ArrayList<>();
//	private ArrayList<Object> arraysame1 = new ArrayList<>();
//	private ArrayList<Object> arraydifferent = new ArrayList<>();
	
	
	Queue array1;
	Queue array2;
	Queue arrayBad;
		

	
	///vars
	
	@BeforeEach 
	void setup() {
				
		
	}
	
	
	@Test
	void test() {
		SimpleQueue queue = new SimpleQueue();
		testQueue(queue);
		
		RingBuffer ringBuffer = new RingBuffer();
		testQueue(ringBuffer);
	}
	
	
	
//	@Test
//	void testEverything() {
//		assertEquals(0, array1.size());
//		
//		array1.enqueue("Hi");
//		assertEquals(1, array1.size());
//		assertEquals(new Object[] {"Hello"}, array1.toArray());
//		
//		array1.enqueue(12);
//		assertEquals(2, array1.size());
//		assertEquals(new Object[] {"Hello", 2}, array1.toArray());
//		
//		array1.enqueue(false);
//		assertEquals(3, array1.size());
//		assertEquals(new Object[] {"Hello", 2, false}, array1.toArray());
//		
//		
//		assertEquals(new Object[] {"Hello"}, array1.dequeue());
//		assertEquals(2, array1.size());
//		
//		
//		assertEquals(0, arrayBad.size());
//		arrayBad.enqueue("Bye");
//		assertEquals(1, arrayBad.size());
//		
//		
//		array2.enqueue(2);
//		array2.enqueue(false);
//		
//		
//		assertEquals(array1, array2);
//		assertNotEquals(array1, arrayBad);
//		
//	}
	
	void testQueue(Queue queue) {
		assertEquals(0, queue.size());
		
		queue.enqueue("hello");
		assertEquals(1, queue.size());
		assertArrayEquals(new Object[] {"hello"}, queue.toArray());
		
		queue.enqueue(42);
		assertEquals(2, queue.size());
		assertArrayEquals(new Object[] {"hello", 42}, queue.toArray());

		queue.enqueue(false);
		assertEquals(3, queue.size());
		assertArrayEquals(new Object[] {"hello", 42, false}, queue.toArray());
		
		assertEquals("hello", queue.dequeue());
		assertEquals(2, queue.size());
		assertArrayEquals(new Object[] {42, false}, queue.toArray());
		
		queue.enqueue("foo");
		assertEquals(3, queue.size());
		assertArrayEquals(new Object[] {42, false, "foo"}, queue.toArray());
		
		assertEquals(42, queue.dequeue());
		assertArrayEquals(new Object[] {false, "foo"}, queue.toArray());
		
		SimpleQueue queue2 = new SimpleQueue();
		queue2.enqueue(false);
		queue2.enqueue("foo");
		assertEquals(queue2, queue);
		assertEquals(queue, queue2);
		
		queue.enqueue(11);
		queue.enqueue(22);
		assertEquals(4, queue.size());
		assertArrayEquals(new Object[] {false, "foo", 11, 22}, queue.toArray());
	
		assertNotEquals(queue2, queue);
		assertNotEquals(queue, queue2);
	}
	

}
