package edu.pnu;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class RelationMappingTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
//	@Test
//	public void testManyToOneInsert() {
//		Member m1 = new Member();
//		m1.setId("member1");
//		m1.setPassword("pass1");
//		m1.setName("name1");
//		m1.setRole("MEMBER");
//		memberRepo.save(m1);
//		
//		Member m2 = new Member();
//		m2.setId("member2");
//		m2.setPassword("pass2");
//		m2.setName("name2");
//		m2.setRole("MEMBER");
//		memberRepo.save(m2);
//		
//		Random rd = new Random();
//		for(Long i = 1L; i <= 20L; i++) {
//			Board b = new Board();
//			b.setMember(m1);
//			b.setTitle("member1 게시글 " + i);
//			b.setContent("member1 테스트 내용 " + i);
//			b.setCreateDate(new Date());
//			b.setCnt(rd.nextLong(100));
//			boardRepo.save(b);
//		}
//		
//		for(Long i = 1L; i <= 20L; i++) {
//			Board b = new Board();
//			b.setMember(m2);
//			b.setTitle("member2 게시글 " + i);
//			b.setContent("member2 테스트 내용 " + i);
//			b.setCreateDate(new Date());
//			b.setCnt(rd.nextLong(100));
//			boardRepo.save(b);
//		}
//	}

//	@Test
//	public void testManyToOneSelect() {
//		Board board = boardRepo.findById(5L).get();
//		System.out.println("[ " + board.getSeq() + "번 게시글 정보 ]");
//		System.out.println("제목 : " + board.getTitle());
//		System.out.println("내용 : " + board.getContent());
//		System.out.println("작성자 : " + board.getMember().getName());
//		System.out.println("작성자 권한 : " + board.getMember().getRole());
//	}
	
//	@Test
//	public void testMemberToBoardSet() {
//		Board board = boardRepo.findById(5L).get();
//		Member member = memberRepo.findById("member2").get();
//		
//		board.setMember(member);
//		boardRepo.save(board);
//	}
	
	@Test
	public void testTwoWayMapping() {
		Member member = memberRepo.findById("member1").get();
		
		System.out.println("========================");
		System.out.println(member.getName() + "가(이) 저장한 게시글 목록");
		System.out.println("========================");
		List<Board> list = member.getBoardList();
		for(Board b : list) {
			System.out.println(b);
		}
	}
}
