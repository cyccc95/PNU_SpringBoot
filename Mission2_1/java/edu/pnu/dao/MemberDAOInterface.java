package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberDAOInterface {

	List<MemberVO> getMembers();

	MemberVO getMember(Integer id);

	MemberVO addMember();

	MemberVO updateMember(Integer id);

	MemberVO removeMember(Integer id);

}