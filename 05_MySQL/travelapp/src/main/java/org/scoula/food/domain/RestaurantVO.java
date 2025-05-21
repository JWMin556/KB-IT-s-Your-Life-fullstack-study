package org.scoula.food.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantVO {
    private int id;
    private String name;
    private String category;
    private String address;
    private String description;
    private List<RestaurantReviewVO> reviews;
}