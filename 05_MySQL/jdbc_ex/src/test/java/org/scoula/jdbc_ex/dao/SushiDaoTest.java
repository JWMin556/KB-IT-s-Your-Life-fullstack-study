package org.scoula.jdbc_ex.dao;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.CustomerVO;
import org.scoula.jdbc_ex.domain.SushiLogVO;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SushiDaoTest {
    SushiDao dao = new SushiDaoImpl();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @BeforeEach
    @DisplayName("중복 방지 처리")
    void setUp() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");

        dao.insertCustomer(new CustomerVO("cust01", "김초밥"));
        dao.insertSushiLog(new SushiLogVO("cust01", "red"));
        dao.insertSushiLog(new SushiLogVO("cust01", "blue"));
        dao.insertSushiLog(new SushiLogVO("cust01", "gold"));
    }

    @Test
    @DisplayName("새로운 customer를 등록한다.")
    @Order(1)
    void insertCustomer() throws SQLException {
        dao.insertCustomer(new CustomerVO("cust02", "이연어"));
    }

    @Test
    @DisplayName("새로운 스시로그를 등록한다")
    @Order(2)
    void insertSushiLog() throws SQLException {
        dao.insertSushiLog(new SushiLogVO("cust01", "red"));
    }


    @Test
    @DisplayName("고객의 접시 기록을 콘솔에 출력한다")
    void printSushiLogByCustomer() throws SQLException {
        dao.printSushiLogByCustomer("cust01");
    }
}