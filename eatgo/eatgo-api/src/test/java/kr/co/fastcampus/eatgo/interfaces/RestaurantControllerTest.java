package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.RestaurantService;
import kr.co.fastcampus.eatgo.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestaurantRepository restaurantRepository;
    @MockBean
    private MenuItemRepository menuItemRepository;
    @MockBean
    private RestaurantService restaurantService;

    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(Restaurant.builder().id(1004L).name("Bob zip").location("seoul").build());

        mvc.perform(get("/restaurants")).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")));
    }

    @Test
    public void detailWithExised() throws Exception {
        Restaurant restaurant = Restaurant.builder().id(1004L).name("JmKanmo").location("cheonan").build();
        MenuItem menuItem = MenuItem.builder().name("Kimchi").price(5000).build();
        restaurant.setMenuItems(Arrays.asList(menuItem));

        Review review = Review.builder().name("JmKanmo").score(100).description("맛잇어요").build();

        restaurant.setReview(Arrays.asList(review));

        given(restaurantService.getRestaurantById(1004L)).willReturn(restaurant);

        mvc.perform(get("/restaurants/1004")).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"JmKanmo\"")))
                .andExpect(content().string(containsString("Kimchi")))
                .andExpect(content().string(containsString("맛잇어요")));
    }

    @Test
    public void detailWithNotExised() throws Exception {
        given(restaurantService.getRestaurantById(4044L)).willThrow(new RestaurantNotFoundException(4044L));
        mvc.perform(get("/restaurants/4044"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("{}"));
    }

    @Test
    public void createWithValidData() throws Exception {
        mvc.perform(post("/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"jmkanmo\",\"id\":3450, \"location\":\"Cheonan\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/restaursnts/0"))
                .andExpect(content().string("{}"));

        verify(restaurantService).addRestaurant(any());
    }

    @Test
    public void createWithInvalidData() throws Exception {
        mvc.perform(post("/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"\",\"id\":3450, \"location\":\"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void update() throws Exception {
        mvc.perform(patch("/restaurants/1004")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"jmkanmo\",\"location\":\"Cheonan\"}"))
                .andExpect(status().isOk());
//        verify(restaurantService).updateRestaurant(1004,"kanmo zip", "USA");
    }

    @Test
    public void invalidUpdate() throws Exception {
        mvc.perform(patch("/restaurants/1004")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"\",\"location\":\"\"}"))
                .andExpect(status().isBadRequest());
    }
}