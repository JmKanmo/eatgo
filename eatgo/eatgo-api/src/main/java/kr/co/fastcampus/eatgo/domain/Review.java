package kr.co.fastcampus.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private long restaurantId;
    @NotEmpty
    private String name;
    @NotNull
    private Integer score;
    @NotEmpty
    private String description;

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
