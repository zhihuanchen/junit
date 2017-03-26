package io.xuexi.ut.junit.asserts;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertDemo {
	
	@Test
	public void testPass() {
		assertTrue(true);
		assertFalse(false);
		
		assertEquals(5, (3 + 2));
		assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
		
		assertSame(AssertThatDemo.class, AssertThatDemo.class);
		assertNotSame(new Object(), new Object());
		
		assertNotNull(new Object());
		assertNull(null);
	}

	@Test
	public void testAssertWithMessage() {
		assertTrue("should be true", false);
		assertEquals("the result is incorrect", 5, (3 + 2));
	}
}
