package edu.pnu.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBConnect(String driver, String url, String id, String pwd) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("[JDBConnect] DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[JDBConnect] 연결 중 예외 발생");
		}
	}
}
