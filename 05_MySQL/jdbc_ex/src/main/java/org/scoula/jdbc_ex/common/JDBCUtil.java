package org.scoula.jdbc_ex.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    static Connection conn = null;  // connection 객체는 딱 한번만 연결하면 됨 (인스턴스가 하나만 운영 -> singleton패턴)
    static {
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties")); // 절대경로로 준다
            // 참고로 classpath의 경로에서 볼 때, root는 main의 java와 main의 resources다
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String password = properties.getProperty("password");
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        return conn;
    }
    
    public static void close() {  // close를 할 때도 예외처리가 필요
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
