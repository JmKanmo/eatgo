package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuItem> menuItems;

    public void updateInfo(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addMenuItems(MenuItem menuItem) {
        if(this.menuItems==null){
            this.menuItems = new ArrayList<>();
        }
        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        if(menuItems==null)
            return;

        for (MenuItem menuItem : menuItems) {
            addMenuItems(menuItem);
        }
    }
}
