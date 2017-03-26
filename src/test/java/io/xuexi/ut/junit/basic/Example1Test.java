package io.xuexi.ut.junit.basic;

import static org.junit.Assert.*;
import io.xuexi.ut.junit.basic.Example1;

import org.junit.Test;

public class Example1Test {

	@Test
	public void testPlus() {
		Example1 example1 = new Example1();

		int a = 10;
		int b = 20;
		final int expectResult = 30;
		int actualResult = example1.plus(a, b);
		assertEquals(expectResult, actualResult);
	}

	// @Test
	// no annotation, this test method will not active
	public void testPlusNotActive() {
		fail("if this is a valid case, it will fail here");
	}

	// not public, this test method will not active and the case will fail
	// remove the comment and try it
	/*
	@Test
	private void testPlusNotPublic() {

	}
	*/
}
