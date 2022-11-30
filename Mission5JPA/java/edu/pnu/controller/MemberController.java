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

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	private MemberService memberService;
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
		log.info("MemberController() 생성자가 호출됨");
	}
	
	@GetMapping("/member")
	public List<Member> getMembers(){
		log.info("MemberController - getMembers()가 호출됨");
		return memberService.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public Member getMember(@PathVariable Integer id) {
		log.info(String.format("MemberController - getMember(%d)가 호출됨", id));
		return memberService.getMember(id);
	}
	
	@PostMapping("/member")
	public Member addMember(Member member) {
		log.info(String.format("MemberController - addMember(%s)가 호출됨", member));
		return memberService.addMember(member);
	}
	
	@PutMapping("/member")
	public Member updateMember(Member member) {
		log.info(String.format("MemberController - updateMember(%s)가 호출됨", member));
		return memberService.updateMember(member);
	}
	
	@DeleteMapping("/member/{id}")
	public Member deleteMember(@PathVariable Integer id) {
		log.info(String.format("MemberController - deleteMember(%d)가 호출됨", id));
		return memberService.deleteMember(id);
	}
}
