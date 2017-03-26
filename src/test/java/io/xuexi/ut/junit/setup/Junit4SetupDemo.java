package io.xuexi.ut.junit.setup;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Junit4SetupDemo {

	public Junit4SetupDemo() {
		System.out.println("new instance");
	}

	@BeforeClass
	public static void initialeforeClass() {
		System.out.println("call initialeforeClass()");
	}

	@Before
	public void initial() {
		System.out.println("call initial()");
	}

	@Test
	public void testCase1() {
		System.out.println("run testCase1");
	}

	@Test
	public void testCase3() {
		System.out.println("run testCase3");
	}

	@Test
	public void testCase2() {
		System.out.println("run testCase2");
	}

	@After
	public void clean() {
		System.out.println("call clean()");
	}

	@AfterClass
	public static void cleanAfterClass() {
		System.out.println("call cleanAfterClass()");
	}
}
