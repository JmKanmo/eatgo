package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Review;
import kr.co.fastcampus.eatgo.domain.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements  ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review addReview(long restaurantId,Review review) {
        review.setRestaurantId(restaurantId);
        return reviewRepository.save(review);
    }
}
