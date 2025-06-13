package org.scoula.stock.mapper;

import org.scoula.stock.domain.StockVO;

import java.util.List;

public interface StockMapper {
    List<StockVO> getList();
    StockVO get(Long no);
}
