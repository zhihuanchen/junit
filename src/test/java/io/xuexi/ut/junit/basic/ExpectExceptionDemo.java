package io.xuexi.ut.junit.basic;

import org.junit.Test;

public class ExpectExceptionDemo {

	@Test(expected=RuntimeException.class)
	public void test() {
		throw new RuntimeException("error message");
	}
	
	@Test
	public void testFailureBecauseException() {
		throw new RuntimeException("error message");
	}
	
	@Test(expected=RuntimeException.class)
	public void testFailureBecauseNoSuchException() {
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailureBecauseNotExpectException() {
		throw new RuntimeException("error message");
	}
}
