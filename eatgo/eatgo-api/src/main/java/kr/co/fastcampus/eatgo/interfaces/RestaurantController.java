package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.RestaurantService;
import kr.co.fastcampus.eatgo.domain.*;
import kr.co.fastcampus.eatgo.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list() throws Exception {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") long id) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        return restaurant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@Valid @RequestBody Restaurant body) throws URISyntaxException {
        String name = body.getName();
        String location = body.getLocation();
        Restaurant restaurant =Restaurant.builder().name(name).location(location).build();
        restaurantService.addRestaurant(restaurant);
        return ResponseEntity.created(new URI("/restaursnts/" + restaurant.getId())).body("{}");
    }

    @PatchMapping("/restaurants/{id}")
    public String update(@PathVariable("id") Long id, @Valid @RequestBody Restaurant restaurant) {
        String name = restaurant.getName();
        String location = restaurant.getLocation();
        restaurantService.updateRestaurant(id,name,location);
        return "{}";
    }
}
