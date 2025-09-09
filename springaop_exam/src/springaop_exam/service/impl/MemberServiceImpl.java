package springaop_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springaop_exam.dao.MemberDao;
import springaop_exam.model.Member;
import springaop_exam.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<Member> selectListMember() {
		return memberDao.listMember();
	}
	
	@Override
	public Member selectGetMember(String mid) {
		return memberDao.getMember(mid);
	}
	
	@Override
	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}
	
	@Override
	public int updateMember(Member member) {
		return memberDao.updateMember(member);
	}
	
	@Override
	public int deleteMember(String mid) {
		return memberDao.deleteMember(mid);
	}
	
}
