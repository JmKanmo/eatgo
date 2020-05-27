package kr.co.fastcampus.eatgo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuItemRepository extends CrudRepository<MenuItem,Long> {
    MenuItem findAllByRestaurantId(long id) throws Exception;
}
