package edu.pnu.service;

import edu.pnu.dao.MemberDAOH2Impl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;

import java.util.List;

public class MemberService {
    private MemberInterface memberDAO;

    public MemberService(){
        memberDAO = new MemberDAOH2Impl();
        //memberDAO = new MemberDAOListImpl();
    }

    public List<MemberVO> getMembers(){
        return memberDAO.getMembers();
    }

    public MemberVO getMember(Integer id){
        return memberDAO.getMember(id);
    }

    public MemberVO addMember(MemberVO member){
        return memberDAO.addMember(member);
    }

    public MemberVO updateMember(MemberVO member){
        return memberDAO.updateMember(member);
    }

    public int deleteMember(Integer id){
        return memberDAO.deleteMember(id);
    }
}
