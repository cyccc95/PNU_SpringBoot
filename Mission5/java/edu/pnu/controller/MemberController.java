package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.LogVO;
import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	private MemberService memberService;
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
		log.info("MemberController 호출");
	}
	
	@GetMapping("/mission5")
	public List<MemberVO> getMembers() {
		return memberService.getMembers();
	}
	
	@GetMapping("/mission5/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return memberService.getMember(id);
		
	}
	
	@PostMapping("/mission5")
	public MemberVO addMember(String name, String pass) {
		return memberService.addMember(name, pass);
	}
	
	@PutMapping("/mission5/{id}")
	public MemberVO updateMembers(@PathVariable Integer id, String name, String pass) {
		return memberService.updateMember(id, name, pass);
	}
	
	@DeleteMapping("/mission5/{id}")
	public MemberVO deleteMember(@PathVariable Integer id) {
		return memberService.deleteMember(id);
	}
	
	@GetMapping("/mission5/log")
	public List<LogVO> getLogs(){
		return memberService.getLogs();
	}
}
