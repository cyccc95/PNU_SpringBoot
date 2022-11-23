package edu.pnu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;
import edu.pnu.jdbc.JDBConnect;


public class MemberDAOH2 extends JDBConnect implements MemberDAOInterface{
	private List<MemberVO> memberList;
	private String query;
	
	public MemberDAOH2() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/test", "sa", "");
	}

	@Override
	public List<MemberVO> getMembers() {
		try {
			query = "select * from member";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			memberList = new ArrayList<>();
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPass(rs.getString("pass"));
				member.setName(rs.getString("name"));
				member.setRegidate(rs.getDate("regidate"));
				memberList.add(member);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("멤버 목록을 가져오는 중 예외 발생");
			e.printStackTrace();
			return null;
		}
		return memberList;
	}
	
	@Override
	public MemberVO getMember(String id) {
		MemberVO member = new MemberVO();
		try {
			query = String.format("select * from member where id='%s'",id);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPass(rs.getString("pass"));
				member.setName(rs.getString("name"));
				member.setRegidate(rs.getDate("regidate"));
			}
		} catch (SQLException e) {
			System.out.println("멤버를 가져오는 중 예외 발생");
			e.printStackTrace();
			return null;
		}
		if(member.getId() == null) return null;
		return member;
	}
	
	@Override
	public MemberVO addMember(String id, String pass, String name) {
		MemberVO member = new MemberVO();
		try {
			member.setId(id);
			member.setPass(pass);
			member.setName(name);
			member.setRegidate(new Date());
			query = String.format("insert into member (id, pass, name)"
					+ " values ('%s','%s','%s')", id, pass, name);
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("멤버를 추가하는 중 예외 발생");
			e.printStackTrace();
			return null;
		}
		if(member.getId() == null) return null;
		return member;
	}
	
	@Override
	public MemberVO updateMember(String id) {
		MemberVO member = getMember(id);
		try {
			member.setName(member.getName() + member.getName());
			query = String.format("update member set name= '%s' where id='%s'", member.getName(), id);
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("멤버를 수정하는 중 예외 발생");
			e.printStackTrace();
			return null;
		}
		if(member.getId() == null) return null;
		return member;
	}
	
	@Override
	public MemberVO removeMember(String id) {
		MemberVO member = getMember(id);
		try {
			query = String.format("delete from member where id='%s'", id);
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("멤버를 삭제하는 중 예외 발생");
			e.printStackTrace();
			return null;
		}
		if(member.getId() == null) return null;
		return member;
	}

	@Override
	public String getSql() {
		return query;
	}
}