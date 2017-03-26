package io.xuexi.ut.junit.asserts;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class AssertjDemo {

	@Test
	public void testAssertThat() {
		// assertTrue(true);
		assertThat(true).isTrue();
		// assertFalse(false);
		assertThat(false).isFalse();

		// assertEquals(5, (3 + 2));
		assertThat(5).isEqualTo(3 + 2);

		// assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
		assertThat(new int[] { 1, 2, 3 }).isEqualTo(new int[] { 1, 2, 3 });

		// assertSame(AssertThatDemo.class, AssertThatDemo.class);
		assertThat(AssertjDemo.class).isSameAs(AssertjDemo.class);
		// assertNotSame(new Object(), new Object());
		assertThat(new Object()).isNotSameAs(new Object());

		// assertNotNull(new Object());
		assertThat(new Object()).isNotNull();
		// assertNull(null);
		String a = null;
		assertThat(a).isNull();
		a = "";
		assertThat(a).isNullOrEmpty();
	}

	@Test
	public void testAssertThatMorePower() {
		// text/string
		 assertThat("abc").isEqualToIgnoringCase("aBC");
		 assertThat("abc").isEqualToIgnoringWhitespace("abc ");
		 assertThat("abc").contains("b");
		 assertThat("abc123").startsWith("abc").endsWith("123");

		// numeric
		 assertThat(123).isGreaterThan(100);
		 assertThat(123).isLessThan(200);
		 assertThat(123).isGreaterThanOrEqualTo(123);
		 assertThat(123).isLessThanOrEqualTo(123);
		 assertThat(97).isCloseTo(100, within(5));
		 assertThat(0.999).isCloseTo(1.0, within(0.01));
		 
		// type match
		 Object a = "abc";
		assertThat(a).isInstanceOf(String.class);
	}
}
