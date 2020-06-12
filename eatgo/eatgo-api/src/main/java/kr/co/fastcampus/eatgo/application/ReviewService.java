package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Review;

public interface ReviewService {
    Review addReview(long restaurantId,Review review);
}
