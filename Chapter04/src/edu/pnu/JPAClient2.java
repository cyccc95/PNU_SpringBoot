package edu.pnu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient2 {
	
	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04H2");
		EntityManager em = emf.createEntityManager();
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			// Transaction 시작
			tx.begin();

			// 수정할 게시글 조회
			Board board = em.find(Board.class, 1L);
			board.setTitle("검색한 게시글의 제목 수정");
			
			// 삭제할 게시글 조회
			Board board1 = em.find(Board.class, 1L);
			board1.setSeq(1L);
			
			// 게시글 삭제
//			board1.setSeq(1L);
			em.remove(board1);
			
			// Transaction commit
			tx.commit();
			System.out.println("----->Commit");
		} catch (Exception e) {
			e.printStackTrace();
			// Transaction rollback
			tx.rollback();
			System.out.println("----->Rollback");
		} finally {
			em.close();
			emf.close();
		}
		System.out.println("----->Done!!!!");
	}

}
