package springtest.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springtest.bean.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springtest/conf/applicationContext.xml")
public class PersonTest {

	@Autowired
	private ApplicationContext context;
	
	@Before
	public void before() {
		System.out.println("단위테스트 시작!");
	}

	@After
	public void after() {
		System.out.println("단위테스트 종료!");
	}
	
	@Test
	public void test1() {
		// 실습: 이름이 홍길동이고 나이가 20살이고 학생인 Person 객체 생성
		Person hong = (Person)context.getBean("person");
		hong.setName("홍길동");
		hong.setAge(20);
		hong.setStudent(true);
		
		// 실습: hong 객체가 null인지 테스트
		assertNotNull(hong);
		
		// 실습: hong 객체의 나이가 20살인지 테스트
		assertEquals(20, hong.getAge());
		
		// 실습: hong 객체가 학생인지 테스트
		assertEquals(true, hong.isStudent());
		
		// 실습: 이름이 강감찬이고 나이가 30살이고 학생이 아닌 Person 객체 생성
		Person kang = (Person)context.getBean("person");
		kang.setName("강감찬");
		kang.setAge(30);
		kang.setStudent(false);
		
		// 실습: 홍길동과 강감찬이 같은 객체인지 테스트
		assertSame(hong, kang);
		
		// 실습: 홍길동의 나이가 강감찬의 나이보다 많은지 테스트
		assertTrue(hong.getAge() > kang.getAge());
		
		// 실습: 홍길동은 학생이고 강감찬은 학생이 아닌지 테스트
		assertTrue(hong.isStudent() && !kang.isStudent());
	}
	
} // class






















