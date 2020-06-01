package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem {
    @Id
    @GeneratedValue
    private long id;
    private long restaurantId;
    private String name;
    private int price;
    @Transient
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean delete;
}
