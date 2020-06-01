package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.MenuItemService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(
            @PathVariable("restaurantId") long restaurantId,
            @RequestBody List<MenuItem> menuItems) throws Exception {
        menuItemService.bulkUpdate(restaurantId,menuItems);
        return "{}";
    }
}
