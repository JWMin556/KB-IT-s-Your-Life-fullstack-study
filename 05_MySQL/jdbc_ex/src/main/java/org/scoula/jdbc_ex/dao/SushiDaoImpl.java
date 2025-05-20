package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.CustomerVO;
import org.scoula.jdbc_ex.domain.SushiLogStatVO;
import org.scoula.jdbc_ex.domain.SushiLogVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class SushiDaoImpl implements SushiDao {
    private String CUSTOMER_INSERT = "insert into customer values (?, ?)";
    private String SUSHILOG_INSERT = "insert into sushi_log (customer_id, plate_color) values (?, ?)";
    private String PRINT_PLATECOLOR = "select plate_color, eaten_at from customer join sushi_log on sushi_log.customer_id = customer.id where customer.id = ? order by eaten_at desc";
    private String PRINT_MOST_LOVE_PLATECOLOR = """
            select plate_color, count(*) as cnt, max(eaten_at) as last_eaten
            from customer join sushi_log on sushi_log.customer_id = customer.id 
            where customer.id = ?
            group by plate_color
            order by cnt desc, last_eaten desc
            limit 1
            """;

    @Override
    public void insertCustomer(CustomerVO customer) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(CUSTOMER_INSERT);
            pstmt.setString(1, customer.getId());
            pstmt.setString(2, customer.getName());
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {pstmt.close();}
        }
    }

    @Override
    public void insertSushiLog(SushiLogVO log) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(SUSHILOG_INSERT);
            pstmt.setString(1, log.getCustomerId());
            pstmt.setString(2, log.getPlateColor());
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {pstmt.close();}
        }
    }

    @Override
    public void printSushiLogByCustomer(String customerId) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(PRINT_PLATECOLOR);
            pstmt.setString(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            int count = 1;
            while (rs.next()) {
                System.out.println(count + ". " + rs.getString("plate_color") + "     (" + rs.getString("eaten_at") + ")" );
                count++;
            }
        } finally {
            if (pstmt != null) {pstmt.close();}
        }
    }

    @Override
    public Optional<SushiLogStatVO> findFavoriteColor(String customerId) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(PRINT_MOST_LOVE_PLATECOLOR);
            pstmt.setString(1, customerId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String plateColor = rs.getString("plate_color");
                int count = rs.getInt("cnt");
                return Optional.of(new SushiLogStatVO(plateColor, count));
            } else {
                return Optional.empty();
            }
        } finally {
            if (rs != null) {rs.close();}
            if (pstmt != null) {pstmt.close();}
        }
    }
}
