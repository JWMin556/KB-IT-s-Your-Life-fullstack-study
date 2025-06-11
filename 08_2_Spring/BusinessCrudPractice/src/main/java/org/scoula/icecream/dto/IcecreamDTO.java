package org.scoula.icecream.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.icecream.domain.IcecreamVO;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IcecreamDTO {
    private Long no;
    private String name;
    private String flavor;
    private Long price;
    private Date regDate;

    // VO  DTO 변환
    public static IcecreamDTO of(IcecreamVO vo) {
        return vo == null ? null : IcecreamDTO.builder()
                .no(vo.getNo())
                .name(vo.getName())
                .flavor(vo.getFlavor())
                .price(vo.getPrice())
                .regDate(vo.getRegDate())
                .build();
    }

    // DTO -> VO 변환
    public IcecreamVO toVo() {
        return IcecreamVO.builder()
                .no(no)
                .name(name)
                .flavor(flavor)
                .price(price)
                .regDate(regDate)
                .build();
    }
}
