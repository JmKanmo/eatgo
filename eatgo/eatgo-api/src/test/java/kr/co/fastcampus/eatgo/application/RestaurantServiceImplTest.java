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
import static org.mockito.Mockito.verify;

public class RestaurantServiceImplTest {
    private RestaurantService restaurantService;

    @Mock
    private MenuItemRepository menuItemRepository;
    @Mock
    private RestaurantRepository restaurantRepository;
    @Mock
    private ReviewRepository reviewRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockRestaurantRepository();
        mockMenuItemRepository();
        mockReviewRepository();
        restaurantService = new RestaurantServiceImpl(restaurantRepository, menuItemRepository,reviewRepository);
    }

    private void mockRestaurantRepository(){
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(Restaurant.builder().id(1004L).name ("bob zip").location("Seoul").build());
        restaurants.add(Restaurant.builder().id(2020L).name ("junmo zip").location("Seoul").build());
        given(restaurantRepository.findAll()).willReturn(restaurants);
        given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurants.get(0)));
    }

    private void mockMenuItemRepository() throws Exception {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(MenuItem.builder().id(1L).restaurantId(1004L).name("kimchi").price(5000).build());
        menuItems.add(MenuItem.builder().id(2L).restaurantId(1004L).name("jjajangmyun").price(6000).build());
        menuItems.add(MenuItem.builder().id(3L).restaurantId(1004L).name("icecreamcake").price(10000).build());
        given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItems);
    }

    private void mockReviewRepository(){
        List<Review> reviews =new ArrayList<>();
        reviews.add(Review.builder().name("JmKanmo").score(100).description("I'm a best programmer").build());
        reviews.add(Review.builder().name("billy").score(200).description("Sex on the beach").build());
        reviews.add(Review.builder().name("fuck that").score(50).description("Byung shin").build());
        given(reviewRepository.findAllByRestaurantId(1004L)).willReturn(reviews);
    }

    @Test
    public void getRestaurantWithExisted() throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantById(1004L);
        verify(menuItemRepository).findAllByRestaurantId(1004L);
        verify(reviewRepository).findAllByRestaurantId(1004L);
        assertThat(restaurant.getId(),is(1004L));
        MenuItem menuItem = restaurant.getMenuItems().get(0);
        assertThat(menuItem.getName(),is("kimchi"));
        assertThat(restaurant.getReview().get(1).getDescription(),is("Sex on the beach"));
    }

    @Test(expected = RestaurantNotFoundException.class)
    public void getRestaurantWithNotExisted() throws Exception {
        restaurantService.getRestaurantById(4044L);
    }

    @Test
    public void getRestaurants() throws Exception {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        verify(restaurantRepository).findAll();
    }

    @Test
    public void addRestaurant() {
        Restaurant restaurant = Restaurant.builder().name("junmo").location("seoul").build();
        given(restaurantRepository.save(any())).willReturn(restaurant);
        Restaurant created = restaurantService.addRestaurant(restaurant);
        assertThat(created.getId(), is(3040L));
    }

    @Test
    public void updateRestaurant() {
        Restaurant restaurant = Restaurant.builder().id(2020L).build();
        given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurant));
        Restaurant updated = restaurantService.updateRestaurant(1004L, "Kanmo zip", "cheonan");
        assertThat(updated.getName(), is("Kanmo zip"));
        assertThat(updated.getLocation(), is("cheonan"));
    }
}