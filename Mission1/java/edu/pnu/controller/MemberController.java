package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	private MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
		System.out.println("MemberController 생성");
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		return memberService.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return memberService.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember() {
		return memberService.addMember();
	}
	
	
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO memberVO) {
		// 수정할 memberVO
		memberVO = memberService.getMember(5);
		return memberService.updateMember(memberVO);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {
		return memberService.removeMember(id);
	}
}
