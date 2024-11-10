package umc.spring.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import umc.spring.domain.*;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final EntityManager entityManager;
    private final QRestaurant Restaurant = QRestaurant.restaurant;
    private final QUser User = QUser.user;

    public Review createReview(Long userId, Long restaurantId, Float rating, String content) {
        Review newReview = Review.builder()
                .user(user)
                .restaurant(restaurant)
                .rating(rating)
                .content(content)
                .build();

        entityManager.persist(newReview);

        return newReview;
    }
}
