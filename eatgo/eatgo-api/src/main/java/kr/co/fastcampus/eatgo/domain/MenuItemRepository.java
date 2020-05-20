package kr.co.fastcampus.eatgo.domain;

import java.util.List;

public interface MenuItemRepository {
    MenuItem findAllByRestaurantId(long id) throws Exception;
    List<MenuItem> findAllRestaurants()throws  Exception;
}
