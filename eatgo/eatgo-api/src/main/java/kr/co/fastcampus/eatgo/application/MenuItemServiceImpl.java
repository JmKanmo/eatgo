package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.MenuItemRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {
    private MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public boolean bulkUpdate(long restaurantId, List<MenuItem> menuItems) throws Exception {
        for(MenuItem menuItem:menuItems){
            menuItem.setRestaurantId(restaurantId);
            menuItemRepository.save(menuItem);
            System.out.println(menuItem.getId()+" "+menuItem.getName());
        }
        return true;
    }
}
