package edu.pnu.dao.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class LogDAOH2Impl implements LogDAO{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LogDAOH2Impl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addLog(String method, String sqlString, boolean success) {
        String sqlstring = "insert into dblog (method, sqlstring, success) values (?,?,?)";
        try {
            jdbcTemplate.update(sqlstring, method, sqlString, success);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
