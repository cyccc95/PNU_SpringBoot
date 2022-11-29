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
        memberService = new MemberService();
    }

    @GetMapping("/member")
    public List<MemberVO> getMembers(){
        log.info("getMembers()");
        return memberService.getMembers();
    }

    @GetMapping("/member/{id}")
    public MemberVO getMember(@PathVariable Integer id){
        log.info("getMember()");
        return memberService.getMember(id);
    }

    @PostMapping("/member")
    public MemberVO addMember(MemberVO member){
        log.info("addMember()");
        return memberService.addMember(member);
    }

    @PutMapping
    public MemberVO updateMember(MemberVO member){
        log.info("updateMember()");
        return memberService.updateMember(member);
    }

    @DeleteMapping("/member/{id}")
    public MemberVO deleteMember(@PathVariable Integer id){
        log.info("deleteMember()");
        return memberService.deleteMember(id);
    }
}