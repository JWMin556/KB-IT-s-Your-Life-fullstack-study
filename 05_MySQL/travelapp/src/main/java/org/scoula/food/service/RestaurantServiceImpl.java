package org.scoula.food.service;

import lombok.RequiredArgsConstructor;
import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.domain.RestaurantVO;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    final RestaurantDao restaurantDao;

    @Override
    public void printRestaurantWithReviews() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("조회할 맛집 ID를 입력하라: ");
        int id = scanner.nextInt();
        RestaurantVO restaurant = restaurantDao.getRestaurantWithReviews(id).orElseThrow(NullPointerException::new);
        System.out.println("[맛집 정보]");
        System.out.println("이름: " + restaurant.getName());
        System.out.println("카테고리" + restaurant.getCategory());
        System.out.println("주소: " + restaurant.getAddress());
        System.out.println("설명: " + restaurant.getDescription());
        System.out.println("\n[리뷰 목록]");
        if (restaurant.getReviews() != null) {
            restaurant.getReviews().forEach(review -> {
                System.out.println("- " + review.getWriter() + "(" + review.getScore() + "점): " + review.getContent());
            });
        } else {
            System.out.println("등록된 리뷰가 없습니다.");
        }
    }
}
