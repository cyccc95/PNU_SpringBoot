package edu.pnu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.domain.MyLog;
import edu.pnu.domain.MyMethod;
import edu.pnu.repository.MemberRepository;
import edu.pnu.repository.MyLogRepository;
import jakarta.annotation.PostConstruct;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MyLogRepository myLogRepository;
	
	@PostConstruct
	public void init() {
		for (int i = 1; i <= 5; i++) {
			memberRepository.save(new Member(i, "pass"+i, "name"+i, new Date()));
		}
	}
	
	public List<Member> getMembers(){
		myLogRepository.save(new MyLog(0, MyMethod.GET, "getMembers()", true));
		return memberRepository.findAll();
	}

	public Member getMember(Integer id) {
		Member m = memberRepository.findById(id).get(); 
		myLogRepository.save(new MyLog(0, MyMethod.GET, String.format("getMember(%s)", m), true));
		return m;
	}
	
	public Member addMember(Member member) {
		member.setRegidate(new Date());
		member = memberRepository.save(member); 
		myLogRepository.save(new MyLog(0, MyMethod.POST, String.format("addMember(%s)", member), true));
		return member;
	}
	
	public Member updateMember(Member member) {
		Member m = memberRepository.findById(member.getId()).get();
		m.setName(member.getName());
		m.setPass(member.getPass());
		m.setRegidate(new Date());
		myLogRepository.save(new MyLog(0, MyMethod.PUT, String.format("updateMember(%s)", m), true));
		return memberRepository.save(m);
	}
	
	public Member deleteMember(Integer id) {
		Member m = memberRepository.findById(id).get(); 
		myLogRepository.save(new MyLog(0, MyMethod.DELETE, String.format("deleteMember(%s)", m), true));
		memberRepository.deleteById(id);
		return m;
	}
}
