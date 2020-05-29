package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class RestaurantServiceImplTest {
    private RestaurantService restaurantService;

    @Mock
    private MenuItemRepository menuItemRepository;
    @Mock
    private RestaurantRepository restaurantRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        setUpMockRepository();
        restaurantService = new RestaurantServiceImpl(restaurantRepository, menuItemRepository);
    }

    private void setUpMockRepository() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        List<MenuItem> menuItems = new ArrayList<>();

        restaurants.add(new Restaurant(1004L, "bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "junmo zip", "Seoul"));

        menuItems.add(new MenuItem(1L, "kimchi", 5000));
        menuItems.add(new MenuItem(2L, "jjajangmyun", 6000));
        menuItems.add(new MenuItem(3L, "icecreamcake", 10000));

        given(restaurantRepository.findAll()).willReturn(restaurants);
//        given(menuItemRepository.findAllByRestaurantId(any())).willReturn(menuItems);

        given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurants.get(0)));
    }

    @Test
    public void getRestaurant() throws Exception {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        System.out.println(restaurants.get(0).getMenuItems().get(0).getName());
        assertThat(restaurants.get(0).getName(), is("bob zip"));
    }

    @Test
    public void getRestaurants() throws Exception {
        assertThat(restaurantService.getRestaurants().get(0).getId(), is(1004L));
    }

    @Test
    public void addRestaurant() {
        Restaurant restaurant = new Restaurant("junmo", "seoul");
        given(restaurantRepository.save(any())).willReturn(restaurant);
        Restaurant created = restaurantService.addRestaurant(restaurant);
        assertThat(created.getId(), is(3040L));
    }

    @Test
    public void updateRestaurant() {
        Restaurant restaurant = new Restaurant(1004L, "", "");
        given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurant));
        Restaurant updated = restaurantService.updateRestaurant(1004L, "Kanmo zip", "cheonan");
        assertThat(updated.getName(), is("Kanmo zip"));
        assertThat(updated.getLocation(), is("cheonan"));
    }
}