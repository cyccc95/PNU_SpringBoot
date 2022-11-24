package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LogInterface;
import edu.pnu.dao.MemberDAOH2Interface;
import edu.pnu.domain.LogVO;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService implements MemberDAOH2Interface, LogInterface{
	
	private MemberDAOH2Interface memberDAO;
	private LogInterface logDAO;
	private List<MemberVO> list;
	private MemberVO member;
	
	@Autowired
	public MemberService(MemberDAOH2Interface memberDAO, LogInterface logDAO) {
		this.memberDAO = memberDAO;
		System.out.println("MemberDAOH2 생성");
		this.logDAO = logDAO;
		System.out.println("LogDAO 생성");
	}

	@Override
	public List<MemberVO> getMembers() {
		list = memberDAO.getMembers();
		logDAO.addLog("GET",memberDAO.getSqlString(), true);
		return list;
	}

	@Override
	public MemberVO getMember(Integer id) {
		member = memberDAO.getMember(id);
		if(member == null) {
			logDAO.addLog("GET", memberDAO.getSqlString(), false); return null;
		} else {
			logDAO.addLog("GET", memberDAO.getSqlString(), true); return member;
		}
	}

	@Override
	public MemberVO addMember(String name, String pass) {
		member = memberDAO.addMember(name, pass);
		if(member == null) {
			logDAO.addLog("POST", memberDAO.getSqlString(), false); return null;
		} else {
			logDAO.addLog("POST", memberDAO.getSqlString(), true); return member;
		}
	}

	@Override
	public MemberVO updateMember(Integer id, String name, String pass) {
		member = memberDAO.updateMember(id, name, pass);
		if(member == null) {
			logDAO.addLog("PUT", memberDAO.getSqlString(), false); return null;
		} else {
			logDAO.addLog("PUT", memberDAO.getSqlString(), true); return member;
		}
	}

	@Override
	public MemberVO deleteMember(Integer id) {
		member = memberDAO.deleteMember(id);
		if(member == null) {
			logDAO.addLog("DELETE", memberDAO.getSqlString(), false); return null;
		} else {
			logDAO.addLog("DELETE", memberDAO.getSqlString(), true); return member;
		}
	}

	@Override
	public Integer getMaxId() {
		return null;
	}

	@Override
	public String getSqlString() {
		return memberDAO.getSqlString();
	}

	@Override
	public List<LogVO> getLogs() {
		return logDAO.getLogs();
	}

	@Override
	public void addLog(String method, String sqlString, boolean success) {
		
	}
}
