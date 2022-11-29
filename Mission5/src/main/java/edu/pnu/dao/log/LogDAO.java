package edu.pnu.dao.log;

public interface LogDAO {
    void addLog(String method, String sqlString, boolean success);
}
