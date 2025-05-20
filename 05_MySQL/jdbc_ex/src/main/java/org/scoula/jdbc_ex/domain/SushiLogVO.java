package org.scoula.jdbc_ex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SushiLogVO {
    private int id;
    private String customerId;
    private String plateColor;
    private LocalDateTime eatenAt;

    public SushiLogVO(String cust01, String color) {
        this.customerId = cust01;
        this.plateColor = color;
    }
}
