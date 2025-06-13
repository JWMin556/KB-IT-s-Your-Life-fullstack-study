package org.scoula.stock.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.stock.domain.StockVO;
import org.scoula.stock.dto.StockDTO;
import org.scoula.stock.mapper.StockMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    final private StockMapper mapper;

    @Override
    public List<StockDTO> getList() {
        log.info("getList..........");

        return mapper.getList().stream()
                .map(StockDTO::of)
                .toList();
    }

    @Override
    public StockDTO get(Long no) {
        log.info("get......" + no);
        StockDTO stock = StockDTO.of(mapper.get(no));
        return Optional.ofNullable(stock)
                .orElseThrow(NoSuchElementException::new);
    }
}
