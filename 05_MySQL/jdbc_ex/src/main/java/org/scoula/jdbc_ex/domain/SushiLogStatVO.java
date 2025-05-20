package org.scoula.jdbc_ex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SushiLogStatVO {
    private String plateColor;
    private int count;

    @Override
    public String toString() {
        return "최애 접시는 " + plateColor + " (" + count + "회)";
    }
}
