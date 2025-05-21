package org.scoula.food.app;

import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.dao.RestaurantDaoImpl;
import org.scoula.food.service.RestaurantService;
import org.scoula.food.service.RestaurantServiceImpl;

public class RestaurantApp {
    public static void main(String[] args) {
        RestaurantDao dao = new RestaurantDaoImpl();
        RestaurantService service = new RestaurantServiceImpl(dao);
        service.printRestaurantWithReviews();
    }
}
