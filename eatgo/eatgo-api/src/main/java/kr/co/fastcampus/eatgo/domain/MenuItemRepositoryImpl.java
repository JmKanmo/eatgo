package kr.co.fastcampus.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemRepositoryImpl implements  MenuItemRepository{
    private List<MenuItem>menuItems = new ArrayList<>();

    public MenuItemRepositoryImpl(){
        menuItems.add(new MenuItem(1L, "kimchi",5000));
        menuItems.add(new MenuItem(2L, "jjajangmyun",6000));
        menuItems.add(new MenuItem(3L, "icecreamcake",10000));
    }

    @Override
    public MenuItem findAllByRestaurantId(long id) throws  Exception {
        return this.menuItems.stream().filter(e->e.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<MenuItem> findAllRestaurants() throws Exception {
        return menuItems;
    }
}
