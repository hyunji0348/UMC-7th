package umc.spring.service.ReviewService;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import umc.spring.domain.Review;
//import umc.spring.domain.User;
//import umc.spring.repository.ReviewRepository.ReviewRepository;
//import umc.spring.repository.ReviewRepository.ReviewRepository;
//import umc.spring.repository.StoreRepository.StoreRepository;
//
//@Service
//@RequiredArgsConstructor
//public class ReviewQueryServiceImpl implements ReviewQueryService {
//
//    private final ReviewRepository reviewRepository;
//
//    @Transactional
//    @Override
//    public Review createReview(Long userId, Long restaurantId, Float rating, String content) {
//        return reviewRepository.createReview(userId, restaurantId, rating, content);
//    }
//}


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.User;
import umc.spring.domain.Review;
import umc.spring.domain.Restaurant;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    @Override
    public Review createReview(Long userId, Long restaurantId, Float rating, String content) {
        User member = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException());
        Restaurant store = storeRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException());

        Review review =  Review.builder()
                .rating(rating)
                .content(content)
                .user(member)
                .restaurant(store)
                .build();
        return reviewRepository.save(review);
    }

}