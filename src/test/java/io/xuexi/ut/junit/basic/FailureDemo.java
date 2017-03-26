package io.xuexi.ut.junit.basic;

import org.junit.Test;
import static org.junit.Assert.*;

public class FailureDemo {

	@Test
	public void testFailure() {
		//do some test
		if (true) {
			fail();
		}
	}
	
	@Test
	public void testFailureWithMessage() {
		//do some test
		if (true) {
			fail("erroe message");
		}
	}
}
