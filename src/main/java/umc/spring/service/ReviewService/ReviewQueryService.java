package umc.spring.service.ReviewService;

import umc.spring.domain.Review;

public interface ReviewQueryService {
    Review createReview(Long memberId, Long restaurantId, Float rating, String content);
}