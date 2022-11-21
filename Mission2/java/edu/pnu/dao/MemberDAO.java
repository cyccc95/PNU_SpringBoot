package edu.pnu.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import edu.pnu.domain.MemberVO;
import edu.pnu.jdbc.JDBConnect;


public class MemberDAO extends JDBConnect {
	private Map<Integer ,MemberVO> memberMap;
	
	public MemberDAO() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/test", "sa", "");
		memberMap = new HashMap<>();
		
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
				memberMap.put(Integer.parseInt(rs.getString("id")), member);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("멤버 목록을 가져오는 중 예외 발생");
			e.printStackTrace();
		}
	}
	
	public Map<Integer, MemberVO> getMembers() {
		return memberMap;
	}
	
	public MemberVO getMember(Integer id) {
		try {
			String query = "select * from member where id=\'" + Integer.toString(id) + "\'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {	// 데이터가 하나라도 rs.next()로 찾아줘야함
				if (memberMap.containsKey(id)) {
					return memberMap.get(id);
				}
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("멤버를 가져오는 중 예외 발생");
			e.printStackTrace();
		}
		return null;
	}
	
	public MemberVO addMember() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId(Integer.toString(memberMap.size() + 1));
		memberVO.setName("musthave" + Integer.toString(memberMap.size() + 1));
		memberVO.setPass("1234");
		memberVO.setRegidate(new Date());
		memberMap.put(memberMap.size() + 1, memberVO);
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
	
	public MemberVO updateMember(Integer id) {
		MemberVO updateMember = memberMap.get(id);
		String newName = updateMember.getName() + " " + updateMember.getName();
		updateMember.setName(newName);
		memberMap.replace(id, updateMember);
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
	
	public MemberVO removeMember(Integer id) {
		MemberVO removeMember = memberMap.get(id);
		memberMap.remove(id);
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