package org.scoula.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.stock.domain.StockVO;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDTO {
    private Long no;
    private String stockCode;
    private String stockName;
    private Long price;
    private String description;
    private Date regDate;

    // VO  DTO 변환
    public static StockDTO of(StockVO vo) {
        return vo == null ? null : StockDTO.builder()
                .no(vo.getNo())
                .stockCode(vo.getStockCode())
                .stockName(vo.getStockName())
                .price(vo.getPrice())
                .description(vo.getDescription())
                .regDate(vo.getRegDate())
                .build();
    }

    // DTO  VO 변환
    public StockVO toVO() {
        return StockVO.builder()
                .no(no)
                .stockCode(stockCode)
                .stockName(stockName)
                .price(price)
                .description(description)
                .regDate(regDate)
                .build();
    }
}
