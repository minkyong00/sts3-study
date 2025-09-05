package springtest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class AssertMethodTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass: 테스트 클래스 시작 시 한번만 실행");
	}

	@Before
	public void before() {
		System.out.println("@Before : @Test 시작 전에 실행");
	}

	@After
	public void after() {
		System.out.println("@After : @Test 종료 후에 실행");
	}
	
	@Test
	public void testAssertEquals() {
		System.out.println("testAssertEquals 메소드 실행");
		assertEquals(5, 2 + 3); // 값이 같은지 단정
	}
	
	@Test
	public void testAssertNotEquals() {
		System.out.println("testAssertNotEquals 메소드 실행");
		assertNotEquals(5, 1 + 2); // 값이 같지 않은지 단정
	}
	
	@Test
	public void testAssertTrue() {
		System.out.println("testAssertTrue 메소드 실행");
		assertTrue(10 > 0); // true인지 단정
	}

	@Test
	public void testAssertFalse() {
		System.out.println("testAssertFalse 메소드 실행");
		assertFalse(10 > 20); // false인지 단정
	}
	
	@Test
	public void testAssertNull() {
		System.out.println("testAssertNull 메소드 실행");
		Object obj = null;
		assertNull(obj); // null인지 단정
	}

	@Test
	public void testAssertNotNull() {
		System.out.println("testAssertNotNull 메소드 실행");
		Object obj = new Object();
		assertNotNull(obj); // not null인지 단정
	}
	
	@Test
	public void testAssertSame() {
		System.out.println("testAssertSame 메소드 실행");
		Object obj1 = new Object();
		Object obj2 = obj1;
		assertSame(obj1, obj2); // 두 객체가 같은지 단정 (참조값이 같은지 단정)
	}
	
	@Test
	public void testAssertNotSame() {
		System.out.println("testAssertNotSame 메소드 실행");
		Object obj1 = new Object();
		Object obj2 = new Object();
		assertNotSame(obj1, obj2); // 두 객체가 다른 객체인지 단정 (참조값이 다른지 단정)
	}
	
	@Test
	public void testAssertArrayEquals() {
		System.out.println("testAssertArrayEquals 메소드 실행");
		int[] intArr1 = {1, 2, 3};
		int[] intArr2 = {1, 2, 3};
		assertArrayEquals(intArr1, intArr2); // 두 배열이 같은지 단정
	}

	@Test
	public void testFail() {
		System.out.println("testFail 메소드 실행");
		try {
			int result = 10 / 0; // 예외 발생
			fail("예외 발생 메세지");
		} catch(ArithmeticException ae) {
			ae.printStackTrace();
		}
	}
	
	@Ignore
	public void ignoreTest() {
		System.out.println("테스트 수행 안함");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("@AfterClass: 테스트 클래스 종료 전 한번만 실행");
	}
	
} // class


























