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
		log.addLog(dao.getSql());
		return list;
	}

	@Override
	public MemberVO getMember(Integer id) {
		memberVO = dao.getMember(id);
		log.addLog(dao.getSql());
		return memberVO;
	}

	@Override
	public MemberVO addMember() {
		memberVO = dao.addMember();
		log.addLog(dao.getSql());
		return memberVO;
	}

	@Override
	public MemberVO updateMember(Integer id) {
		memberVO = dao.updateMember(id);
		log.addLog(dao.getSql());
		return memberVO;
	}

	@Override
	public MemberVO removeMember(Integer id) {
		memberVO = dao.removeMember(id);
		log.addLog(dao.getSql());
		return memberVO;
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
	public LogVO addLog(String logQuery) {
		return log.addLog(logQuery);
	}

}