package edu.pnu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient {
	public static void test(EntityManagerFactory emf) {
		// EntityManager 생성
		EntityManager em = emf.createEntityManager();
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			// Transaction 시작
			tx.begin();
			
			for(int i = 1; i <= 10; i++) {
				Board board = new Board();
				board.setTitle("JPA 제목" + i);
				board.setWriter("관리자");
				board.setContent("JPA 내용" + i);
				board.setCreateDate(new Date());
				board.setCnt(0L);
				
				// 글 등록
				em.persist(board);
			}
			
			// 에러 발생 코드
			Board board = new Board();
			board.setSeq(1L);
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 내용");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			// 글 등록
			em.persist(board);
			
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
		}
		System.out.println("----->Done!!!!");
	}
	
	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04H2");
		EntityManager em = emf.createEntityManager();
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			// Transaction 시작
			tx.begin();
			
			for(int i = 1; i <= 10; i++) {
				Board board = new Board();
				board.setTitle("JPA 제목" + i);
				board.setWriter("관리자");
				board.setContent("JPA 내용" + i);
				board.setCreateDate(new Date());
				board.setCnt(0L);
				
				// 글 등록
				em.persist(board);
			}
			
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
		}
		
		test(emf);
		emf.close();
		System.out.println("----->Done!!!!");
	}

}
