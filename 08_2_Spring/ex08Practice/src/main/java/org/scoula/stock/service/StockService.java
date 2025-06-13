package org.scoula.stock.service;

import org.scoula.stock.domain.StockVO;
import org.scoula.stock.dto.StockDTO;

import java.util.List;

public interface StockService {
    List<StockDTO> getList();
    StockDTO get(Long no);
}
