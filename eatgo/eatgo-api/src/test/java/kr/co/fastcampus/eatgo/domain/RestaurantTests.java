package kr.co.fastcampus.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTests {
    @Test
    public void creation(){
        Restaurant restaurant = new Restaurant("Bob zip");
        assertThat(restaurant.getBob_zip(),is("Bob zip"));
    }

    @Test
    public void information(){
        Restaurant restaurant = new Restaurant("Bob zip", "Seoul");
        assertThat(restaurant.getSeoul(),is("Seoul"));
    }

}