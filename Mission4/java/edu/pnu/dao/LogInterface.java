package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.LogVO;

public interface LogInterface {
	
	List<LogVO> getLogs();
	
	void addLog(String method, String sqlString, boolean success);
}
