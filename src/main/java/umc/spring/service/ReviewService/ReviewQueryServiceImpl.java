package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Transactional
    @Override
    public Review createReview(Long userId, Long restaurantId, Float rating, String content) {
        return reviewRepository.createReview(userId, restaurantId, rating, content);
    }
}