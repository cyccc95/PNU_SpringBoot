package edu.pnu.dao.member;

import edu.pnu.domain.MemberVO;

import java.util.Map;

public interface MemberInterface {

    Map<String, Object> getMembers();

    Map<String, Object> getMember(Integer id);

    Map<String, Object> addMember(MemberVO member);

    Map<String, Object> updateMember(MemberVO member);

    Map<String, Object> deleteMember(Integer id);
}
