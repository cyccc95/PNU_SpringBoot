package edu.pnu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pnu.connect.JDBConnect;
import edu.pnu.domain.MemberVO;

@Repository
public class MemberDAOH2 extends JDBConnect implements MemberDAOH2Interface {
	
	private List<MemberVO> memberList;
	private String query;
	
	public MemberDAOH2() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/test", "sa", "");
	}

	@Override
	public List<MemberVO> getMembers() {
		try {
			query = "select * from Mission5";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			memberList = new ArrayList<>();
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
				member.setRegidate(rs.getDate("regidate"));
				memberList.add(member);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("getMembers 중 예외 발생");
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public MemberVO getMember(Integer id) {
		MemberVO member = new MemberVO();
		try {
			query = String.format("select * from Mission5 where id='%s'", Integer.toString(id));
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
				member.setRegidate(rs.getDate("regidate"));
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("getMember 중 예외 발생");
			e.printStackTrace();
			return null;
		}
		if(member.getId() == null) return null;
		return member;
	}

	@Override
	public MemberVO addMember(String name, String pass) {
		int id = getMaxId();
		MemberVO member = new MemberVO();
		try {
			member.setId(id);
			member.setName(name);
			member.setPass(pass);
			member.setRegidate(new Date());
			query = String.format("insert into Mission5 (name, pass)"
					+ " values ('%s','%s')", name, pass);
			if(member.getName().equals("") || member.getPass().equals("")) return null;
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
		} catch (Exception e) {
			System.out.println("addMember 중 예외 발생");
			e.printStackTrace();
			return null;
		}
		return member;
	}

	@Override
	public MemberVO updateMember(Integer id, String name, String pass) {
		MemberVO member = getMember(id);
		try {
			query = String.format("update Mission5 set name='%s', pass='%s' where id='%s'",
					name, pass, id);
			if(member.getId() == null || member.getName().equals("") || member.getPass().equals("")) return null;
			member.setName(name);
			member.setPass(pass);
			member.setRegidate(new Date());
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
		} catch (Exception e) {
			System.out.println("updateMember 중 예외 발생");
			e.printStackTrace();
			return null;
		}
		return member;
	}

	@Override
	public MemberVO deleteMember(Integer id) {
		MemberVO member = getMember(id);
		try {
			query = String.format("delete from Mission5 where id='%s'", Integer.toString(id));
			if(member.getId() == null) return null;
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
		} catch (Exception e) {
			System.out.println("deleteMember 중 예외 발생");
			e.printStackTrace();
			return null;
		}
		return member;
	}

	@Override
	public Integer getMaxId() {
		MemberVO member = new MemberVO();
		try {
			query = "select id from Mission5 order by 1 DESC limit 1";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				member.setId(rs.getInt("id"));
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member.getId() + 1;
	}

	@Override
	public String getSqlString() {
		return query;
	}

}
