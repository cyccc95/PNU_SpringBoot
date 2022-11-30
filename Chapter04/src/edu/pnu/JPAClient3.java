package edu.pnu;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient3 {
	
	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04H2");
		EntityManager em = emf.createEntityManager();
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {

			// 글 목록 조회
			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			for (Board brd : boardList) {
				System.out.println("---> " + brd.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		System.out.println("----->Done!!!!");
	}

}
