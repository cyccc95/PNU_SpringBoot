package edu.pnu.controller;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private MemberService memberService;

    public MemberController(){
        memberService = new MemberService();
    }

    @GetMapping("/member")
    public List<MemberVO> getMembers(){
        return memberService.getMembers();
    }

    @GetMapping("/member/{id}")
    public MemberVO getMember(@PathVariable Integer id){
        return memberService.getMember(id);
    }

    @PostMapping("/member")
    public MemberVO addMember(MemberVO member){
        return memberService.addMember(member);
    }

    @PutMapping("/member")
    public MemberVO updateMember(MemberVO member){
        return memberService.updateMember(member);
    }

    @DeleteMapping("/member/{id}")
    public int deleteMember(@PathVariable Integer id){
        return memberService.deleteMember(id);
    }
}
