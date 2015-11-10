import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class LsetTest {

	@Test
	public void testLset() {
		Lset<String> set = new Lset<>();
		assertTrue("New set instance of Lset", set instanceof Lset);
		assertTrue("New set implements Set151Interface", 
				set instanceof Set151Interface);
	}

	@Test
	public void testLsetCollectionOfQextendsQ() {
		Lset<String> setOne = new Lset<>();
		setOne.add("One");
		setOne.add("Two");
		setOne.add("Three");
		
		Lset<String> setTwo = new Lset<>(setOne);
		assertEquals("Set initialized with another should be same size", 
				setOne.size(), setTwo.size());
		assertTrue("SetOne should be the same as SetTwo", setOne.equals(setTwo));
	}

	@Test
	public void testIterator() {
		Lset<String> set = new Lset<>();
		set.add("One");
		Iterator<String> iterator = set.iterator();
		assertTrue("Iterator should haveNext", iterator.hasNext());
		assertEquals("Should get back first value", "One", iterator.next());
		assertFalse("One item list only has one hasNext()", iterator.hasNext());
	}

	@Test
	public void testAdd() {
		Lset<String> set = new Lset<>();
		set.add("One");
		set.add("Two");
		set.add("Three");
		
		Iterator<String> iterator = set.iterator();
		
		assertEquals("First value should be One", "One", iterator.next());
		assertEquals("Second value should be Two", "Two", iterator.next());
		assertEquals("Third value should be Three", "Three", iterator.next());
	}

	@Test
	public void testClear() {
		Lset<String> set = new Lset<>();
		set.add("One Element");
		set.clear();		
		assertTrue("Cleared list should be empty", set.isEmpty());
		assertEquals("Size of cleared list is zero", 0, set.size());
	}

	@Test
	public void testIsEmpty() {
		Lset<String> set = new Lset<>();
		assertTrue("New list should be empty", set.isEmpty());	
		set.add("One element");	
		assertFalse("List with item should not be empty", set.isEmpty());
	}

	@Test
	public void testContains() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testContainsAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRetainAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSize() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToArray() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToArrayTArray() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

}
