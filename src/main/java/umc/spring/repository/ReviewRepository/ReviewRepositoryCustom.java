package umc.spring.repository.ReviewRepository;

import umc.spring.domain.Review;
import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findReviewsByUserId(Long memberId);  // 유저 ID로 리뷰 목록 조회
    Review createReview(Long memberId, Long storeId, Float score, String content);  // 새로운 리뷰 등록
}