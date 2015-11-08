import static org.junit.Assert.*;

import org.junit.Test;

public class LsetTest {

	@Test
	public void testAdd() {
		fail("Not yet implemented"); // TODO
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
	public void testSize() {
		fail("Not yet implemented"); // TODO
	}

}
