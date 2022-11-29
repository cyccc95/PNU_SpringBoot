package edu.pnu.dao.log;

import java.io.File;
import java.io.FileWriter;

public class LogDAOFileImpl implements LogDAO{

    @Override
    public void addLog(String method, String sqlString, boolean success) {
        try {
            File file = new File("log.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write(method + "," + sqlString + "," + success + "\n");
            fw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
