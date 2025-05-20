package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    Connection conn = JDBCUtil.getConnection();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("새로운 user를 등록한다.")
    @Order(1)
    public void insertUser() throws SQLException {
        String sql = "insert into users (id, password, name, role) values (?, ?, ?, ?)"; // ?개수 조심
        
        // throws SQLException을 했는데, 왜 try을 쓰며, try에 catch는 왜 안했지?
        // 자동닫기를 위해서 
        // PreparedStatement도 try 블럭이 끝날 때, 자동으로 close를 해주기 위해서이다. (예외 처리 목적이 아니다)
        // 여기서는 절대 catch하면 안됨. 이미 throws SQLException을 해주었기에
        
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {  // conn.prepareStatement(sql)이 컴파일 하라는 의미
            pstmt.setString(1, "scoula");  // 데이터베이스는 1부터 시작한다
            pstmt.setString(2, "scoula3");
            pstmt.setString(3, "스콜라");
            pstmt.setString(4, "USER");
            
            int count = pstmt.executeUpdate();
            assertEquals(1, count);  //같으면 통과, 다르면 예외
        }
    }

    @Test
    @DisplayName("user 목록을 추출한다")
    @Order(2)
    public void selectUser() throws SQLException {
        String sql = "select * from users";  //변수처리 파트가 없기에 statement로 진행해도 문제없음
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);  //이때 컴파일됨
        ) {
            // 여기가 매우 중요!!!!!!!!!!!!!!!
            while (rs.next()) { //next가 false라면 테이블을 다 돌았다는 의미이다.
                System.out.println(rs.getString("name"));
            }
        }
    }

    @Test
    @DisplayName("특정 user 검색한다.")
    @Order(3)
    public void selectUserById() throws SQLException {
        String userid = "scoula";
        String sql = "select * from users where id = ?";
        try(PreparedStatement stmt= conn.prepareStatement(sql)){
            stmt.setString(1, userid);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) { System.out.println(rs.getString("name")); }
                else { throw new SQLException("scoula not found"); }  // 반드시 scoula라는 유저 아이디가 있다고 가정하고 진행한 것이다.
                // 이처럼 특정 데이터가 반드시 있어야 한다고 가정했을 때, 화이트 박스 테스트라고 한다.
                // 반대로 무슨 상태인지 모르고 진행하는 테스트를 블랙 박스 테스트라고 한다. 
            }
        }
    }

    @Test
    @DisplayName("특정user 수정한다.")
    @Order(4)
    public void updateUser() throws SQLException{
        String userid = "scoula";
        String sql ="update users set name= ?  where id = ?";  // 두개의 변수처리
        try(PreparedStatement stmt= conn.prepareStatement(sql)){
            stmt.setString(1, "스콜라수정");  // 첫 파라미터
            stmt.setString(2, userid);  // 두 번째 파라미터
            int count = stmt.executeUpdate();  // 쿼리 실행
            assertEquals(1, count);  // 몇 개 수정 되었는지
            // 본래는  Assertions.assertEquals(1, count); 이렇게 해야하지만,  import static org.junit.jupiter.api.Assertions.assertEquals; 덕분에 가능
        }
    }

    @Test
    @DisplayName("지정한 사용자를 삭제한다.")
    @Order(5)
    public void deleteUser() throws SQLException{
        String userid = "scoula";
        String sql ="delete from users where id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, userid);
            int count = stmt.executeUpdate();
            assertEquals(1, count);
        }
    }
}
