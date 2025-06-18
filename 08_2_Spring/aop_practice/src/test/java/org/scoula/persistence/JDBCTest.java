package org.scoula.persistence;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.fail;

@Log4j2
public class JDBCTest {
    @BeforeAll
    public static void setUp(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 이 드라이버가 없다면 에러가 날 것이다.
            // 에러가 없다면 jdbc driver가 메모리에 성공적으로 로드된 것이다.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("JDBC 드라이버 연결이 된다.")
    public void testConnection() {
        String url="jdbc:mysql://localhost:3306/scoula_db";
        try(Connection con = DriverManager.getConnection(url,"scoula","1234")) {
            log.info(con);
        } catch(Exception e){
            fail(e.getMessage());
        }
    }
}
