package edu.pnu.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

@RestController
public class MemberController {
	private MemberDAO m;
	
	public MemberController() {
		m = new MemberDAO();
		System.out.println("MemberController 생성");
	}
	
	@GetMapping("/mission2")
	public Map<Integer, MemberVO> getMembers(){
		return m.getMembers();
	}
	
	@GetMapping("/mission2/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return m.getMember(id);
	}
	
	@PostMapping("/mission2")
	public MemberVO addMember() {
		return m.addMember();
	}
	
	@PutMapping("/mission2/{id}")
	public MemberVO updateMember(@PathVariable Integer id) {
		return m.updateMember(id);
	}
	
	@DeleteMapping("/mission2/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {
		return m.removeMember(id);
	}
}
