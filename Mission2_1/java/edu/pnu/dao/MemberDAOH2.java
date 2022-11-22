package edu.pnu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;
import edu.pnu.jdbc.JDBConnect;


public class MemberDAOH2 extends JDBConnect implements MemberDAOInterface {
	private List<MemberVO> memberList;
	
	public MemberDAOH2() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/test", "sa", "");
		memberList = new ArrayList<>();
		
		try {
			String query = "select * from member";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
				member.setRegidate(rs.getDate("regidate"));
				memberList.add(member);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("멤버 목록을 가져오는 중 예외 발생");
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> getMembers() {
		return memberList;
	}
	
	@Override
	public MemberVO getMember(Integer id) {
		try {
			String query = "select * from member where id=\'" + Integer.toString(id) + "\'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			for(int i = 0; i < memberList.size(); i++) {
				if(memberList.get(i).getId().equals(Integer.toString(id))) {
					return memberList.get(i);
				}
			}
		} catch (SQLException e) {
			System.out.println("멤버를 가져오는 중 예외 발생");
			e.printStackTrace();
		}
		return null;
	}
	
	int maxId = 0;
	public int getMaxId() {
		for(int i = 0; i < memberList.size(); i++) {
			if(Integer.parseInt(memberList.get(i).getId()) > maxId) {
				maxId = Integer.parseInt(memberList.get(i).getId());
			}
		}
		return maxId;
	}
	
	@Override
	public MemberVO addMember() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId(Integer.toString(this.getMaxId() + 1));
		memberVO.setName("musthave" + Integer.toString(this.getMaxId() + 1));
		memberVO.setPass("1234");
		memberVO.setRegidate(new Date());
		memberList.add(memberVO);
		try {
			String query = "insert into member (id, pass, name) values (?,?,?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, memberVO.getId());
			psmt.setString(2, memberVO.getPass());
			psmt.setString(3, memberVO.getName());
			psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			System.out.println("멤버를 추가하는 중 예외 발생");
			e.printStackTrace();
		}
		return memberVO;
	}
	
	@Override
	public MemberVO updateMember(Integer id) {
		MemberVO updateMember = memberList.get(id - 1);
		String newName = updateMember.getName() + " " + updateMember.getName();
		updateMember.setName(newName);
		memberList.set(id - 1, updateMember);
		try {
			String query = "update member set name=? where id=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, newName);
			psmt.setString(2, Integer.toString(id));
			psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			System.out.println("멤버를 수정하는 중 예외 발생");
			e.printStackTrace();
		}
		return updateMember;
	}
	
	@Override
	public MemberVO removeMember(Integer id) {
		MemberVO removeMember = memberList.get(id - 1);
		memberList.remove(id - 1);
		try {
			String query = "delete from member where id=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, Integer.toString(id));
			psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			System.out.println("멤버를 삭제하는 중 예외 발생");
			e.printStackTrace();
		}
		return removeMember;
	}
}