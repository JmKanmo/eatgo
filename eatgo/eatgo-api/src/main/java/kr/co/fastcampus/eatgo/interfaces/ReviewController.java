package kr.co.fastcampus.eatgo.interfaces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.co.fastcampus.eatgo.application.ReviewService;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@Api(tags = {"Review modify API"})
@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @ApiOperation(value = "Review patch", notes = "입력받은 리뷰를 추가한다.")
    @PostMapping("/restaurants/{restaurantId}/reviews")
    public ResponseEntity<?> create(@PathVariable("restaurantId") Long restaurantId, @Valid @RequestBody Review review) {
        Review ret =  reviewService.addReview(restaurantId,review);
        String url = "/restaurants/"+restaurantId+"/reviews/"+ret.getId();
        return ResponseEntity.created(URI.create(url)).body("{}");
    }
}
