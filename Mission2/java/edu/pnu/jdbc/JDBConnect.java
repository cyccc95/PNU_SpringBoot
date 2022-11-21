package edu.pnu.jdbc;

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
			
			System.out.println("[JDBConnect]DB 연결 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {            
            if (rs != null) rs.close(); 
            if (stmt != null) stmt.close();
            if (psmt != null) psmt.close();
            if (con != null) con.close(); 

            System.out.println("[JDBConnect]JDBC 자원 해제");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
}
