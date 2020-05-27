package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    //    @Autowired
    private RestaurantRepository restaurantRepository;

    //    @Autowired
    private MenuItemRepository menuItemRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public Restaurant getRestaurantById(long id) throws Exception {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
        if (restaurant != null) restaurant.setMenuItems((List<MenuItem>) menuItemRepository.findAllByRestaurantId(id));
        return restaurant;
    }

    @Override
    public List<Restaurant> getRestaurants() throws Exception {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        for (Restaurant restaurant : restaurants) {
            restaurant.setMenuItems((List<MenuItem>) menuItemRepository.findAllByRestaurantId(restaurant.getId()));
        }
        return restaurants;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
