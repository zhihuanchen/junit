package io.xuexi.ut.junit.setup;

import junit.framework.TestCase;

public class Junit3SetupDemo extends TestCase {

	@Override
	public void setUp() {
			System.out.println("run setUp()");
	}
	
	public void testCase1() {
		System.out.println("run testCase1");
	}
	
	public void testCase2() {
		System.out.println("run testCase2");
	}
	
	@Override
	public void tearDown() {
		System.out.println("run tearDown()");
	}
}
