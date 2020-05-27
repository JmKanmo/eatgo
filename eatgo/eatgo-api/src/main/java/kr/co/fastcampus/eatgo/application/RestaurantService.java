package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Restaurant;

import java.util.List;

public interface RestaurantService {
    public Restaurant getRestaurantById(long id) throws Exception;

    List<Restaurant> getRestaurants() throws Exception;

    Restaurant addRestaurant(Restaurant restaurant);
}
