package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import kr.co.fastcampus.eatgo.domain.RestaurantRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantServiceImplTest {
    private RestaurantService restaurantService;
    @Before
    public void setUp(){
        restaurantService = new RestaurantServiceImpl();
    }

    @Test
    public void getRestaurant(){
    RestaurantRepository restaurantService = new RestaurantRepositoryImpl();
    assertThat(restaurantService.findById(1004L).getId(),is(1004L));
    }

    @Test
    public void getRestaurants(){
        RestaurantRepository restaurantService = new RestaurantRepositoryImpl();
        assertThat(restaurantService.findAll().get(0).getId(),is(1004L));
    }
}