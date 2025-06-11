package org.scoula.icecream.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IcecreamVO {
    private Long no;
    private String name;
    private String flavor;
    private Long price;
    private Date regDate;
}
