package edu.pnu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.LogVO;
import edu.pnu.connect.JDBConnect;

@Repository
public class LogDAO extends JDBConnect implements LogInterface {
	private List<LogVO> logList;
	private String query;
	
	public LogDAO() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/test", "sa", "");
	}

	@Override
	public List<LogVO> getLogs() {
		logList = new ArrayList<>();
		try {
			query = "select * from dblog";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				LogVO log = new LogVO();
				log.setId(rs.getInt("id"));
				log.setMethod(rs.getString("method"));
				log.setSqlstring(rs.getString("sqlString"));
				log.setRegidate(rs.getDate("regidate"));
				log.setSuccess(rs.getBoolean("success"));
				logList.add(log);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("로그 목록을 가져오는 중 예외 발생");
			e.printStackTrace();
		}
		return logList;
	}

	@Override
	public void addLog(String method, String sqlString, boolean success) {
		try {
			query = "insert into dblog (method, sqlString, success) values (?,?,?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, method);
			psmt.setString(2, sqlString);
			psmt.setBoolean(3, success);
			psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}