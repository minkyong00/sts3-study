package springaop_exam.dao;

import java.util.List;

import springaop_exam.model.Member;

public interface MemberDao {

public default List<Member> listMember() { return null; }
	
	public default Member getMember(String mid) { return null; }
	
	public default int insertMember(Member member) { return 0; }
	
	public default int updateMember(Member member) { return 0; }
	
	public default int deleteMember(String mid) { return 0; }
	
}
