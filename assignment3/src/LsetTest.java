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
		assertEquals("New Lset should have size of 0", set.size(), 0);
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
		assertFalse("One item list only have one hasNext()", iterator.hasNext());
		set.add("Two");
		assertTrue("Iterator should now haveNext", iterator.hasNext());
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
		Lset<String> set = new Lset<>();
		assertFalse("Empty set should not contain anything", set.contains("Hello"));
		set.add("hello");
		set.add("joe");
		set.add("what do you know");
		assertTrue("Set should now contain joe", set.contains("joe"));
	}

	@Test
	public void testContainsAll() {
		Lset<String> large = new Lset<>();
		Lset<String> small = new Lset<>();
		large.add("One");
		large.add("Two");
		large.add("Three");
		large.add("Four");
		
		small.add("Two");
		small.add("Three");
		assertTrue("Large set should contain small", large.containsAll(small));
		assertFalse("Small set should not contain large", small.containsAll(large));
	}

	@Test
	public void testRemove() {
		Lset<String> set = new Lset<>();
		set.add("One");
		set.add("Two");
		set.remove("Two");
		assertTrue("Two item list with one removed, should have size 1",
				set.size() == 1);
		set.remove("Two");
		assertFalse("Cannot remove same element again", set.remove("Two"));
		set.remove("Two");
	}

	@Test
	public void testAddAll() {
		Lset<Integer> newSet = new Lset<>();
		Lset<Integer> oldSet = new Lset<>();
		newSet.add(1);
		oldSet.add(2);
		oldSet.add(3);
		
		newSet.addAll(oldSet);
		assertEquals("Items in new set, plus, oldset ,should equal 3", newSet.size(), 3);
	}

	@Test
	public void testRemoveAll() {
		Lset<String> largeSet = new Lset<>();
		Lset<String> smallSet = new Lset<>();
		
		largeSet.add("One");
		largeSet.add("Two");
		largeSet.add("Three");
		
		smallSet.add("One");
		smallSet.add("Three");
		
		largeSet.removeAll(smallSet);
		assertEquals("Three item set, with two item set removed, should have size of 1",
				largeSet.size(), 1);
	}

	@Test
	public void testRetainAll() {
		Lset<String> large = new Lset<>();
		Lset<String> small = new Lset<>();
		
		large.add("One");
		large.add("Two");
		large.add("Three");
		
		small.add("One");
		
		large.retainAll(small);
		assertEquals("Small should now equal large", small, large);
	}

	@Test
	public void testSize() {
		Lset<Double> set = new Lset<>();
		set.add(0.0);
		set.add(1.1);
		set.add(2.2);
		assertEquals("Lset with three elements should have size 3", 
				set.size(), 3);
		set.remove(1.1);
		assertEquals("After removing one element, size should be 2", 
				set.size(), 2);
	}

	@Test
	public void testEquals() {
		Lset<Double> emptyOne = new Lset<>();
		Lset<Double> emptyTwo = new Lset<>();
		
		assertEquals("Two empty sets should be equal", emptyOne, emptyTwo);
		emptyOne.add(2.2);
		emptyTwo.add(2.2);
		assertEquals("Two of the same sets should be equal", emptyOne, emptyTwo);
		emptyOne.remove(2.2);
		assertFalse("Two different sets are not equal", emptyOne.equals(emptyTwo));
	}

	@Test
	public void testToString() {
		Lset<Integer> set = new Lset<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		assertEquals("toString should be <1, 2, 3>", set.toString(), "<1, 2, 3>");
	}

}
