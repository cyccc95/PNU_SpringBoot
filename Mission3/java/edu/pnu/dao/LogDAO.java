package edu.pnu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.LogVO;
import edu.pnu.domain.MemberVO;
import edu.pnu.jdbc.JDBConnect;

public class LogDAO extends JDBConnect implements LogInterface {
	private List<LogVO> logList;
	private String query;
	
	public LogDAO() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/test", "sa", "");
		logList = new ArrayList<>();
		
		try {
			query = "select * from log";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				LogVO log = new LogVO();
				log.setNum(rs.getInt("num"));
				log.setQuery(rs.getString("query"));
				log.setRegidate(rs.getDate("regidate"));
				logList.add(log);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("로그 목록을 가져오는 중 예외 발생");
			e.printStackTrace();
		}
	}

	@Override
	public List<LogVO> getLogs() {
		query = "select * from log";
		return logList;
	}

	@Override
	public LogVO addLog(String logQuery) {
		LogVO logVO = new LogVO();
		logVO.setNum(logList.size() + 1);
		logVO.setQuery(logQuery);
		logVO.setRegidate(new Date());
		logList.add(logVO);
		try {
			query = "insert into log (query) values (\'" + logQuery + "\')";
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return logVO;
	}
	
}
