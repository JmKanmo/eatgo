package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.MenuItem;

import java.util.List;

public interface MenuItemService {
    public boolean bulkUpdate(long restaurantId, List<MenuItem> menuItems) throws Exception;
}
