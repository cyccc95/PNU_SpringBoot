package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.LogDAO;
import edu.pnu.dao.LogInterface;
import edu.pnu.dao.MemberDAOH2;
import edu.pnu.dao.MemberDAOInterface;
import edu.pnu.dao.MemberDAOList;
import edu.pnu.domain.LogVO;
import edu.pnu.domain.MemberVO;

public class MemberService implements MemberDAOInterface, LogInterface {
	private MemberDAOInterface dao;
	private LogInterface log;
	private List<MemberVO> list;
	private MemberVO memberVO;
	
	public MemberService() {
//		dao = new MemberDAOList();
//		System.out.println("MemberDAOList 생성");
		dao = new MemberDAOH2();
		System.out.println("MemberDAOH2 생성");
		log = new LogDAO();
		System.out.println("LogDAO 생성");
	}

	@Override
	public List<MemberVO> getMembers() {
		list = dao.getMembers();
		if(list.isEmpty()) {
			log.addLog("GET", dao.getSql(), false); return null;
		} else {
			log.addLog("GET", dao.getSql(), true); return list;
		}
	}

	@Override
	public MemberVO getMember(String id) {
		memberVO = dao.getMember(id);
		if(memberVO == null) {
			log.addLog("GET", dao.getSql(), false); return null;
		} else {
			log.addLog("GET", dao.getSql(), true); return memberVO;
		}
	}

	@Override
	public MemberVO addMember(String id, String pass, String name) {
		memberVO = dao.addMember(id, pass, name);
		if(memberVO == null) {
			log.addLog("POST", dao.getSql(), false); return null;
		} else {
			log.addLog("POST", dao.getSql(), true); return memberVO;
		}
	}

	@Override
	public MemberVO updateMember(String id) {
		memberVO = dao.updateMember(id);
		if(memberVO == null) {
			log.addLog("PUT", dao.getSql(), false); return null;
		} else {
			log.addLog("PUT", dao.getSql(), true); return memberVO;
		}
	}

	@Override
	public MemberVO removeMember(String id) {
		memberVO = dao.removeMember(id);
		if(memberVO == null) {
			log.addLog("DELETE", dao.getSql(), false); return null;
		} else {
			log.addLog("DELETE", dao.getSql(), true); return memberVO;
		}
	}

	@Override
	public String getSql() {
		return dao.getSql();
	}
	
	@Override
	public List<LogVO> getLogs() {
		return log.getLogs();
	}

	@Override
	public LogVO addLog(String method, String sqlString, boolean success) {
		return log.addLog(method, sqlString, success);
	}

}