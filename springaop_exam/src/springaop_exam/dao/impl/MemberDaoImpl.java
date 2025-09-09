package springaop_exam.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springaop_exam.dao.MemberDao;
import springaop_exam.model.Member;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<Member> listMember() {
		return template.selectList("member.listMember");
	}
	
	@Override
	public Member getMember(String mid) {
		return template.selectOne("member.getMember", mid);
	}
	
	@Override
	public int insertMember(Member member) {
		return template.insert("member.insertMember", member);
	}
	
	@Override
	public int updateMember(Member member) {
		return template.update("member.updateMember", member);
	}
	
	@Override
	public int deleteMember(String mid) {
		return template.delete("member.deleteMember", mid);
	}

}
