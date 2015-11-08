import static org.junit.Assert.*;

import org.junit.Test;

public class LsetTest {

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testClear() {
		Lset<String> set = new Lset<>();
		
		set.add("One Element");
		set.clear();
		
		assertEquals("Cleared list size should be zero", 0, set.size());
		assertTrue("Cleared list should be empty", set.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		Lset<String> set = new Lset<>();
		
		assertTrue("New set should be empty", set.isEmpty());
		
		set.add("One Element");
		
		assertFalse("One element set should not be empty", set.isEmpty());
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

}
