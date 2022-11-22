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
		return dao.getMembers();
	}

	@Override
	public MemberVO getMember(Integer id) {
		return dao.getMember(id);
	}

	@Override
	public MemberVO addMember() {
		return dao.addMember();
	}

	@Override
	public MemberVO updateMember(Integer id) {
		return dao.updateMember(id);
	}

	@Override
	public MemberVO removeMember(Integer id) {
		return dao.removeMember(id);
	}

	@Override
	public List<LogVO> getLogs() {
		return log.getLogs();
	}
	
	
}