package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.MemberVO;
import com.service.MemberService;

@RestController
public class MemberController {
	
	private MemberService m;
	
	public MemberController() {
		// TODO Auto-generated constructor stub
		m = new MemberService();
	}
 
	
	@GetMapping("/member")
	public List<MemberVO> getMember() {
		return m.getList();
	}
	
	
	
}
