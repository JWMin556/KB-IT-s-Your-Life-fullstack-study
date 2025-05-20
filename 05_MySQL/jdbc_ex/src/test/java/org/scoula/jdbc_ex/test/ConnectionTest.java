package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    // junit의 어노테이션들
    @Test // 얘가 붙은 메서드 앞에 실행 아이콘이 생김
    @DisplayName("jdbc_ex 데이터베이스에 접속한다") // 테스트명이다. 실패했을 때만 얘가 출력됨
    public void testConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");  //드라이버 로드
        String url = "jdbc:mysql://localhost:3306/jdbc_ex";  // 접속 url
        String id = "scoula";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, id, password);
        System.out.println("DB 연결 성공");
        conn.close();
    }
    
    @Test
    @DisplayName("Jdbc_ex에 접속한다.(자동 닫기)")
    public void testConnection2() throws SQLException {
        try (Connection conn = JDBCUtil.getConnection()) {
            System.out.println("DB 연결 성공");
        }
    }
}
