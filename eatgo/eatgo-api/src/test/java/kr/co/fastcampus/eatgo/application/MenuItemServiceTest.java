package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.MenuItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MenuItemServiceTest {
    private MenuItemService menuItemService;
    @Mock
    private MenuItemRepository menuItemRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.menuItemService = new MenuItemServiceImpl(menuItemRepository);
    }
    @Test
    public void bulkUpdate() throws Exception {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(MenuItem.builder().id(1L).name("zisoo").restaurantId(55L).price(39800).build());
        menuItems.add(MenuItem.builder().id(2L).name("zisoo").restaurantId(555L).price(15800).build());
        menuItemService.bulkUpdate(1L,menuItems);
        verify(menuItemRepository,times(2)).save(any());
    }
}