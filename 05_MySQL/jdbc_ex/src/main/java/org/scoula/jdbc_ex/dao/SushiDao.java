package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.domain.CustomerVO;
import org.scoula.jdbc_ex.domain.SushiLogStatVO;
import org.scoula.jdbc_ex.domain.SushiLogVO;

import java.sql.SQLException;
import java.util.Optional;

public interface SushiDao {
    void insertCustomer(CustomerVO customer) throws SQLException;
    void insertSushiLog(SushiLogVO log) throws SQLException;
    void printSushiLogByCustomer(String customerId) throws SQLException;
    Optional<SushiLogStatVO> findFavoriteColor(String customerId) throws SQLException;
}
