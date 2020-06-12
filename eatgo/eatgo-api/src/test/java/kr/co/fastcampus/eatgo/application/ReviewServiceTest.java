package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Review;
import kr.co.fastcampus.eatgo.domain.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
public class ReviewServiceTest {
    private ReviewService reviewService;
    @Mock
    private ReviewRepository reviewRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.reviewService = new ReviewServiceImpl(reviewRepository);
    }

    @Test
    public void addReview(){
        Review review = Review.builder().name("JmKanmo").score(255).description("do my best all the time").build();
        reviewService.addReview(255,review);
        verify(reviewRepository).save(any());
    }
}