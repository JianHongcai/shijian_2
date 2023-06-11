package com.iflytek.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

    private static final String URL="jdbc:mysql://localhost:3306/shijian?characterEncoding=UTF-8";
    private static final String USERNAME="root";
    private static final String PASSWORD="757687424";



    /**
     * 返回connection对象
     * @return
     */
    public static Connection getConnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return conn;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
