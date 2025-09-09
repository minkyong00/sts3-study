package springaop_exam.service;

import java.util.List;

import springaop_exam.model.Member;

public interface MemberService {

	public default List<Member> selectListMember() { return null; }
	
	public default Member selectGetMember(String mid) { return null; }
	
	public default int insertMember(Member member) { return 0; }
	
	public default int updateMember(Member member) { return 0; }
	
	public default int deleteMember(String mid) { return 0; }
	
}
