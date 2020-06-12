package kr.co.fastcampus.eatgo.interfaces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(tags = {"Restaurant modify API"})
@CrossOrigin
@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @ApiOperation(value = "모든 레스토랑정보 반환", notes = "모든 레스토랑정보를 보여준다.")
    @GetMapping("/restaurants")
    public List<Restaurant> list() throws Exception {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @ApiOperation(value = "특정id의 Restaurant 반환", notes = "특정id의 레스토랑정보를 보여준다.")
    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") long id) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        return restaurant;
    }

    @ApiOperation(value = "레스토랑정보 추가", notes = "입력받은 레스토랑의 정보를 추가한다.")
    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@Valid @RequestBody Restaurant body) throws URISyntaxException {
        String name = body.getName();
        String location = body.getLocation();
        Restaurant restaurant =Restaurant.builder().name(name).location(location).build();
        restaurantService.addRestaurant(restaurant);
        return ResponseEntity.created(new URI("/restaursnts/" + restaurant.getId())).body("{}");
    }

    @ApiOperation(value = "레스토랑정보 변경", notes = "입력받은 레스토랑의 정보를 변경한다.")
    @PatchMapping("/restaurants/{id}")
    public String update(@PathVariable("id") Long id, @Valid @RequestBody Restaurant restaurant) {
        String name = restaurant.getName();
        String location = restaurant.getLocation();
        restaurantService.updateRestaurant(id,name,location);
        return "{}";
    }
}
