package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.domain.MemberVO;

public class MemberService {
	private List<MemberVO> list;
	
	public MemberService() {
		list = new ArrayList<>();
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		for (int i = 1; i <= 10; i++) {
			MemberVO m = new MemberVO();
			m.setId(Integer.toString(i));
			m.setName("아이디" + i);
			m.setPass("패스워드" + i);
			m.setRegidate(new Date());
			memberList.add(m);
		}
	}

	public List<MemberVO> getList() {
		return list;
	}

	public void setList(List<MemberVO> list) {
		this.list = list;
	}
}
