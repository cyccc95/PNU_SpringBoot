package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	// Query Method
	List<Board> findByTitle(String searchKeyword);
	
	List<Board>	findByTitleContaining(String searchKeyword);
	
	List<Board>	findByTitleContainingAndCntGreaterThan(String searchKeyword, Long cnt);
	
	List<Board>	findByContentContaining(String searchKeyword);
	
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);
	
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	List<Board> findByCntBetweenOrderBySeqAsc(Long start, Long end);
	
	// Query Annotation
	// 위치 기반 파라미터 사용
//	@Query("select b from Board b where b.title like %?1% order by b.seq desc")
//	List<Board> queryAnnotationTest1(String searchKeyword);
	
	// 이름 기반 파리미터 사용
	@Query("select b from Board b where b.title like %:searchKeyword% order by b.seq desc")
	List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
	
	// 특정 변수만 조회
	@Query("select b.seq, b.title, b.writer, b.createDate from Board b" + 
			" where b.title like %?1% order by b.seq desc")
	List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	
	// 네이티브 쿼리 사용
	@Query(value="select seq, title, writer, create_Date from board"
//			+ " where title like '%'||?1||'%'"
			+ " where title like %?1%"
			+ " order by seq desc", nativeQuery=true)
	List<Object[]> queryAnnotationTest3(String searchKeyword);
	
	// 페이징 및 정렬 처리
	@Query("select b from Board b order by b.seq desc")
	List<Board> queryAnnotationTest4(Pageable paging);
}
