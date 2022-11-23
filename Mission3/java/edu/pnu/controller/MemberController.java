package edu.pnu.controller;

import java.util.List;

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
	private MemberService m;
	
	public MemberController() {
		m = new MemberService();
		System.out.println("MemberController 생성");
	}
	
	@GetMapping("/mission3")
	public List<MemberVO> getMembers(){
		return m.getMembers();
	}
	
	@GetMapping("/mission3/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return m.getMember(id);
	}
	
	@PostMapping("/mission3")
	public MemberVO addMember() {
		return m.addMember();
	}
	
	@PutMapping("/mission3/{id}")
	public MemberVO updateMember(@PathVariable Integer id) {
		return m.updateMember(id);
	}
	
	@DeleteMapping("/mission3/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {
		return m.removeMember(id);
	}
	
	@GetMapping("/mission3/log")
	public List<LogVO> getLogs(){
		return m.getLogs();
	}
}
