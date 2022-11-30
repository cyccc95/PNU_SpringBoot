package edu.pnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.MyLog;

public interface MyLogRepository extends JpaRepository<MyLog, Integer>{
	
}
