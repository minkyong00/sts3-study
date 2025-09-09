package springaop_exam.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springaop_exam.model.Member;
import springaop_exam.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springaop_exam/conf/applicationContext.xml")
public class MemberTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private MemberService memberService;
	
//	@Test
	public void insertMember() {
		Member member = (Member)context.getBean("member");
		member.setMid("kim");
		member.setMname("김길동");
		int result = memberService.insertMember(member);
		assertTrue(result>0);;
	}
	
//	@Test
	public void listMember() {
		List<Member> memberList = memberService.selectListMember();
		assertNotNull(memberList);
	}
	
//	@Test
	public void getMember() {
		Member member = memberService.selectGetMember("hong");
		assertNotNull(member);
	}
	
//	@Test
	public void updateMember() {
		Member member = (Member)context.getBean("member");
		member.setMid("hong");
		member.setMname("홍길동수정");
		int result = memberService.updateMember(member);
		assertTrue(result>0);
	}
	
	@Test
	public void deleteMember() {
		int result = memberService.deleteMember("kim");
		assertTrue(result>0);
	}
	
}
