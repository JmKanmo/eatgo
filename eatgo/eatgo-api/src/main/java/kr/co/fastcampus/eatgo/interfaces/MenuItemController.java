package kr.co.fastcampus.eatgo.interfaces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.co.fastcampus.eatgo.application.MenuItemService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Menu item API"})
@RestController
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @ApiOperation(value = "Menu Item patch", notes = "메뉴 아이템을 추가,생성,삭제한다.")
    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(
            @PathVariable("restaurantId") long restaurantId,
            @RequestBody List<MenuItem> menuItems) throws Exception {
        menuItemService.bulkUpdate(restaurantId,menuItems);
        return "{}";
    }
}
