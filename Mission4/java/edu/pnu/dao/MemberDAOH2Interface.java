package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberDAOH2Interface {

	List<MemberVO> getMembers();
	
	MemberVO getMember(Integer id);
	
	MemberVO addMember(String name, String pass);
	
	MemberVO updateMember(Integer id, String name, String pass);
	
	MemberVO deleteMember(Integer id);
	
	Integer getMaxId();
	
	String getSqlString();
}
