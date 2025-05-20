package org.scoula.jdbc_ex.dao;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.CustomerVO;
import org.scoula.jdbc_ex.domain.SushiLogStatVO;
import org.scoula.jdbc_ex.domain.SushiLogVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SushiFavoriteTest {
    SushiDao dao = new SushiDaoImpl();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @BeforeEach
    void setUp() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");

        dao.insertCustomer(new CustomerVO("cust01", "김초밥"));
        dao.insertSushiLog(new SushiLogVO("cust01", "red"));
        dao.insertSushiLog(new SushiLogVO("cust01", "blue"));
        dao.insertSushiLog(new SushiLogVO("cust01", "gold"));
        dao.insertSushiLog(new SushiLogVO("cust01", "blue"));
        dao.insertSushiLog(new SushiLogVO("cust01", "gold"));
    }

    @Test
    @DisplayName("특정 유저의 가장 좋아하는 접시출력")
    void  testFindFavoriteColor() throws SQLException {
        Optional<SushiLogStatVO> result = dao.findFavoriteColor("cust01");
        if (result.isPresent()) {
            System.out.println("cust01 고객님의 " + result.get());
        } else {
            System.out.println("⚠\uFE0F 접시 기록이 없어 분석할 수 없습니다.");
        }
    }
}
