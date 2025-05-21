package org.scoula.basic.travel.domain;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor  //디폴트 생성자가 필요
@AllArgsConstructor
public class TravelVO {
    private Long no;
    private String district;
    private String title;
    private String description;
    private String address;
    private String phone;
    
    // csv 파일의 첫 번째 줄에 있는 각 헤더명과 동일하게 필드명 정의


    private List<TravelImageVO> images;
}
