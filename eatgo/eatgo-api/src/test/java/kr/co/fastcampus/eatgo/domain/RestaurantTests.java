package kr.co.fastcampus.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTests {
    @Test
    public void creation() {
        Restaurant restaurant = Restaurant.builder().id(1004L).name("Bob zip").location("Seoul").build();
        assertThat(restaurant.getId(), is(1004L));
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getLocation(), is("Seoul"));
    }

    @Test
    public void information() {
        Restaurant restaurant = Restaurant.builder().name("Bob zip").location("Seoul").build();
        assertThat(restaurant.getLocation(), is("Seoul"));
    }

}