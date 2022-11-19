package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberService {

	private List<MemberVO> memberList;
	
	public MemberService() {
		memberList = new ArrayList<>(); 
		for(int i = 1; i <= 10; i++) {
			MemberVO m = new MemberVO();
			m.setId(Integer.toString(i));
			m.setName("네임" + i);
			m.setPass("패스워드" + i);
			m.setRegidate(new Date());
			memberList.add(m);
		}
	}
	
	public List<MemberVO> getMembers(){
		return memberList;
	}
	
	public MemberVO getMember(Integer id) {
		String str = Integer.toString(id);
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getId().equals(str)) {
				return memberList.get(i);
			}
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
	
	public MemberVO addMember() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId(Integer.toString(this.getMaxId() + 1));
		memberVO.setName("네임" + Integer.toString(this.getMaxId() + 1));
		memberVO.setPass("패스워드" + Integer.toString(this.getMaxId() + 1));
		memberVO.setRegidate(new Date());
		memberList.add(memberVO);
		return memberVO;
	}
	
	public MemberVO updateMember(MemberVO memberVO) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(memberVO.getId())) {
				memberList.get(i).setName(memberList.get(i).getName() + " " + memberList.get(i).getName());
				memberList.get(i).setPass(memberList.get(i).getPass() + " " + memberList.get(i).getPass());
				return memberList.get(i);
			}
		}
		return null;
	}
	
	public MemberVO removeMember(Integer id) {
		String str = Integer.toString(id);
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getId().equals(str)) {
				MemberVO remove = memberList.get(i);
				memberList.remove(i);
				return remove;
			}
		}
		return null;
	}
}
