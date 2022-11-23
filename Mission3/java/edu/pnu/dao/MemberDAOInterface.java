package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberDAOInterface {

	List<MemberVO> getMembers();

	MemberVO getMember(String id);

	MemberVO addMember(String id, String pass, String name);

	MemberVO updateMember(String id);

	MemberVO removeMember(String id);
	
	String getSql();
}