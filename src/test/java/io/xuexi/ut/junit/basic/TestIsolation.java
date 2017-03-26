package io.xuexi.ut.junit.basic;

import org.junit.Test;

public class TestIsolation {
	
	private int flag;
	
	public TestIsolation() {
		System.out.println("call constructor");
		flag = 0;
	}

	@Test
	public void testCase1() {
		System.out.println("run testCase1, flag=" + flag);
		flag = 1;
	}
	
	@Test
	public void testCase3() {
		System.out.println("run testCase3, flag=" + flag);
		flag = 3;
	}
	
	@Test
	public void testCase2() {
		System.out.println("run testCase2, flag=" + flag);
		flag = 2;
	}
	
}
