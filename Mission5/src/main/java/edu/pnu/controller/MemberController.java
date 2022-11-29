package edu.pnu.controller;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private MemberService memberService;

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    public MemberController(MemberService memberService){
        log.info("MemberController() 생성자가 호출됨.");
        this.memberService = memberService;
    }

    @GetMapping("/member")
    public List<MemberVO> getMembers(){
        log.info("MemberController - getMembers()가 호출됨.");
        return memberService.getMembers();
    }

    @GetMapping("/member/{id}")
    public MemberVO getMember(@PathVariable Integer id){
        log.info(String.format("MemberController - getMember(%d)가 호출됨.", id));
        return memberService.getMember(id);
    }

    @PostMapping ("/member")
    public MemberVO addMember(MemberVO member){
        log.info(String.format("MemberController - addMember(%s)가 호출됨.", member));
        return memberService.addMember(member);
    }
    @PutMapping ("/member")
    public MemberVO updateMember(MemberVO member){
        log.info(String.format("MemberController - updateMember(%s)가 호출됨.", member));
        return memberService.updateMember(member);
    }
    @DeleteMapping("/member/{id}")
    public MemberVO deleteMember(@PathVariable Integer id){
        log.info(String.format("MemberController - deleteMember(%d)가 호출됨.", id));
        return memberService.deleteMember(id);
    }
}
