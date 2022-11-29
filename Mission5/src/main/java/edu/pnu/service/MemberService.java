package edu.pnu.service;

import edu.pnu.dao.log.LogDAO;
import edu.pnu.dao.log.LogDAOH2Impl;
import edu.pnu.dao.member.MemberDAOH2Impl;
import edu.pnu.dao.member.MemberInterface;
import edu.pnu.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberService {
    @Autowired
    private MemberInterface memberDAO;

    @Autowired
    private LogDAO logDAO;

    @SuppressWarnings("unchecked")
    public List<MemberVO> getMembers(){
        Map<String, Object> map = memberDAO.getMembers();
        List<MemberVO> list = (List<MemberVO>) map.get("data");
        if (list != null) logDAO.addLog("get", (String)map.get("sql"), true);
        else              logDAO.addLog("get", (String)map.get("data"), false);
        return list;
    }

    public MemberVO getMember(Integer id){
        Map<String, Object> map = memberDAO.getMember(id);
        MemberVO member = (MemberVO)map.get("data");
        if (member != null) logDAO.addLog("get", (String)map.get("sql"), true);
        else                logDAO.addLog("get", (String)map.get("sql"), false);
        return member;
    }

    public MemberVO addMember(MemberVO member){
        Map<String, Object> map = memberDAO.addMember(member);
        MemberVO m = (MemberVO) map.get("data");
        if (m != null) logDAO.addLog("post", (String)map.get("sql"), true);
        else           logDAO.addLog("post", (String)map.get("sql"), false);
        return m;
    }

    public MemberVO updateMember(MemberVO member){
        Map<String, Object> map = memberDAO.updateMember(member);
        MemberVO m = (MemberVO) map.get("data");
        if (m != null) logDAO.addLog("put", (String)map.get("sql"), true);
        else           logDAO.addLog("put", (String)map.get("sql"), false);
        return m;
    }

    public MemberVO deleteMember(Integer id){
        Map<String, Object> map = memberDAO.deleteMember(id);
        MemberVO m = (MemberVO)map.get("data");
        if (m != null) logDAO.addLog("delete", (String)map.get("sql"), true);
        else           logDAO.addLog("delete", (String)map.get("sql"), false);
        return m;
    }
}
