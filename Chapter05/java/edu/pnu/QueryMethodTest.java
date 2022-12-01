package edu.pnu;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	
	public void dataPrepare() {
		for (int i = 1; i <= 200; i++) {
			Random random = new Random();
			Board board = new Board();
			board.setTitle("테스트 제목 " + i);
			board.setWriter("테스터");
			board.setContent("테스트 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(random.nextLong(100));
			boardRepo.save(board);
		}
	}
	
//	@Test
//	public void testFindByTitle() {
//		dataPrepare();
//		List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");
//		
//		System.out.println("검색 결과");
//		for (Board b : boardList) {
//			System.out.println("---> " + b.toString());
//		}
//	}
	
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");
//		
//		System.out.println("검색 결과");
//		for (Board b : boardList) {
//			System.out.println("---> " + b.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContainingOrContentContaining() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("17", "17");
//		
//		System.out.println("검색 결과");
//		for(Board b : boardList) {
//			System.out.println("---> " + b.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContainingOrderBySeqDesc() {
//		List<Board>	boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		
//		System.out.println("검색 결과");
//		for(Board b : boardList) {
//			System.out.println("---> " + b.toString());
//		}
//	}
	
	
	// title에 "1"이 포함되는 데이터 출력
//	@Test
//	public void testFindByTitleContaining() {
//		List<Board> boardList = boardRepo.findByTitleContaining("1");
//		
//		System.out.println("검색 결과");
//		for(Board b : boardList) {
//			System.out.println("---> " + b.toString());
//		}
//	}
	
	// title에 "1"이 포함되면서 cnt가 50보다 큰 데이터 출력
	// where title like '%1%' and cnt > 50
//	@Test
//	public void testFindByTitleContainingAndCntGreaterThan() {
//		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50L);
//		
//		System.out.println("검색 결과");
//		for(Board b : boardList) {
//			System.out.println("---> " + b.toString());
//		}
//	}
	
	// Cnt가 10~50 사이인 데이터를 seq 오름차순으로 출력
	// where 10 <= cnt and cnt <= 50 order by asc
//	@Test
//	public void testFindByCntBetweenOrderBySeqAsc() {
//		List<Board> boardList = boardRepo.findByCntBetweenOrderBySeqAsc(10L, 50L);
//		
//		System.out.println("검색 결과");
//		for(Board b : boardList) {
//			System.out.println("---> " + b.toString());
//		}
//	}
	
	// title에 "10"이 포함되거나 content에 "2"가 포함되는 데이터를 seq 내림차순으로 출력
	// where title like "%10%" or content like "%2%" order by desc
	@Test
	public void testFindByTitleContainingOrContentContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
		
		System.out.println("검색 결과");
		for(Board b : boardList) {
			System.out.println("---> " + b.toString());
		}
	}
}
