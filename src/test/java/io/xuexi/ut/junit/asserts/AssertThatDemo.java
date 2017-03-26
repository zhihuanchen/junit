package io.xuexi.ut.junit.asserts;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class AssertThatDemo {

	@Test
	public void testAssertThat() {
		// assertTrue(true);
		assertThat(true, equalTo(true));
		// assertFalse(false);
		assertThat(false, equalTo(false));
		assertThat(false, not(equalTo(true)));

		// assertEquals(5, (3 + 2));
		assertThat(5, equalTo((3 + 2)));

		// assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
		assertThat(new int[] { 1, 2, 3 }, equalTo(new int[] { 1, 2, 3 }));

		// assertSame(AssertThatDemo.class, AssertThatDemo.class);
		assertThat(AssertThatDemo.class, sameInstance(AssertThatDemo.class));
		// assertNotSame(new Object(), new Object());
		assertThat(new Object(), not(sameInstance(new Object())));

		// assertNotNull(new Object());
		assertThat(new Object(), notNullValue());
		// assertNull(null);
		assertThat(null, nullValue());
	}

	@Test
	public void testAssertThatWithMessage() {
		// will fail to show you the error message
		assertThat("should not be null", null, notNullValue());
	}

	@Test
	public void testAssertThatMorePower() {
		// text/string
		assertThat("abc", equalToIgnoringCase("aBC"));
		assertThat("abc", equalToIgnoringWhiteSpace("abc "));
		assertThat("abc", containsString("b"));
		assertThat("abc123", allOf(startsWith("abc"), endsWith("123")));

		// numeric
		assertThat(123, greaterThan(100));
		assertThat(123, lessThan(200));
		assertThat(123, greaterThanOrEqualTo(123));
		assertThat(123, lessThanOrEqualTo(123));
		assertThat(100.000, closeTo(100.0001, 0.001));
		
		// type match
		assertThat("abc", anything());
		assertThat("abc", isA(String.class));
	}
}
