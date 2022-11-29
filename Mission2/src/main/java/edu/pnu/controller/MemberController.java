package edu.pnu.controller;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private MemberService memberService;

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    public MemberController(){
        log.info("MemberController 생성자 호출");
        this.memberService = new MemberService();
    }

    @GetMapping("/member")
    public List<MemberVO> getMembers(){
        log.info("MemberController - getMembers()");
        return memberService.getMembers();
    }

    @GetMapping("/member/{id}")
    public MemberVO getMember(@PathVariable Integer id){
        log.info(String.format("MemberController - getMember(%d)", id));
        return memberService.getMember(id);
    }

    @PostMapping("/member")
    public MemberVO addMember(MemberVO member){
        log.info(String.format("MemberController - addMember(%s)", member));
        return memberService.addMember(member);
    }

    @PutMapping("/member")
    public MemberVO updateMember(MemberVO member){
        log.info(String.format("MemberController - updateMember(%s)", member));
        return memberService.updateMember(member);
    }

    @DeleteMapping("/member/{id}")
    public boolean deleteMember(@PathVariable Integer id){
        log.info(String.format("MemberController - deleteMember(%d)", id));
        return memberService.deleteMember(id);
    }
}
