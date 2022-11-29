package edu.pnu.service;


import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

import java.util.List;

public class MemberService {
    private MemberDAO memberDAO;

    public MemberService(){
        this.memberDAO = new MemberDAO();
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

    public boolean deleteMember(Integer id){
        return memberDAO.deleteMember(id);
    }
}
