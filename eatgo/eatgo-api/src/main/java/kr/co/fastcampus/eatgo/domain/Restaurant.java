package kr.co.fastcampus.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String location;
    @Transient
    private List<MenuItem> menuItems;

    public void updateInfo(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addMenuItems(MenuItem menuItem) {
        if (menuItems == null) {
            menuItems = new ArrayList<>();
        } else {
            menuItems.add(menuItem);
        }
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        if (menuItems == null) {
            return;
        }
        for (MenuItem menuItem : menuItems) {
            addMenuItems(menuItem);
        }
    }
}
