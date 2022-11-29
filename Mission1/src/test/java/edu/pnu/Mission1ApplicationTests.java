package edu.pnu;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Member;
import java.util.Date;

@SpringBootTest
class Mission1ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testGetMembers(){
		MemberService m = new MemberService();
		System.out.println("getMembers");
		System.out.println(m.getMembers());
	}

	@Test
	void testGetMember(){
		MemberService m = new MemberService();
		System.out.println("getMember");
		System.out.println(m.getMember(1));
	}

	@Test
	void testAddMember(){
		MemberService m = new MemberService();
		System.out.println("addMember");
		MemberVO member = new MemberVO(6,"pass6","name6",new Date());
		System.out.println(m.addMember(member));
		System.out.println(m.getMembers());
	}

	@Test
	void updateMember(){
		MemberService m = new MemberService();
		System.out.println("updateMember");
		MemberVO member = new MemberVO(5,"pass55","name55",new Date());
		System.out.println(m.getMembers());
		System.out.println(m.updateMember(member));
		System.out.println(m.getMembers());
	}

	@Test
	void deleteMember(){
		MemberService m = new MemberService();
		System.out.println("deleteMember");
		System.out.println(m.getMembers());
		System.out.println(m.deleteMember(5));
		System.out.println(m.getMembers());
	}

}
