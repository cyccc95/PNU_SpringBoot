package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
class Chapter05ApplicationTests {

	@Autowired
	private BoardRepository boardRepo;
	
//	@Test
//	public void testInsertBoard() {
//		Board board = new Board();
//		board.setTitle("title1");
//		board.setWriter("writer1");
//		board.setContent("content1");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//		
//		boardRepo.save(board);
//	}
	
//	@Test
//	public void testGetBoard() {
//		Board board = boardRepo.findById(1L).get();
//		System.out.println(board.toString());
//	}
	
//	@Test
//	public void testUpdateBoard() {
//		System.out.println("=== 1번 게시글 조회 ===");
//		Board board = boardRepo.findById(1L).get();
//		
//		System.out.println("=== 1번 게시글 제목 수정 ===");
//		board.setTitle("title1 title1");
//		boardRepo.save(board);
//	}
	
	@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(1L);
	}
}
