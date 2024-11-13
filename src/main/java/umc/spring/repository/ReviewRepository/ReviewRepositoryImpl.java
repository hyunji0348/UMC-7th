//package umc.spring.repository.ReviewRepository;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import umc.spring.domain.QReview;
//import umc.spring.domain.QUser;
//import umc.spring.domain.QRestaurant;
//import umc.spring.domain.Review;
//import umc.spring.domain.User;
//import umc.spring.domain.Restaurant;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
//
//    private final JPAQueryFactory queryFactory; // JPAQueryFactory 주입
//    private final QReview review = QReview.review;
//    private final QUser user = QUser.user;
//    private final QRestaurant restaurant = QRestaurant.restaurant;
//
//    // 사용자 ID로 리뷰를 조회하는 메서드
//    @Override
//    public List<Review> findReviewsByUserId(Long userId) {
//        return queryFactory
//                .selectFrom(review)
//                .join(review.user, user)
//                .where(user.id.eq(userId))
//                .fetch();
//    }
//
//    // 새로운 리뷰 등록하는 메서드
//    @Override
//    public Review createReview(Long userId, Long restaurantId, Float rating, String content) {
//        // 새로운 Review 객체 생성
//        Review newReview = Review.builder()
//                .user(user)  // user를 설정 (user 객체는 별도로 조회해야 함)
//                .restaurant(restaurant) // restaurant을 설정 (restaurant 객체도 별도로 조회해야 함)
//                .rating(rating)
//                .content(content)
//                .build();
//
//        // 실제 user와 restaurant을 DB에서 조회하여 set
//        User foundUser = queryFactory.selectFrom(user).where(user.id.eq(userId)).fetchOne();
//        Restaurant foundRestaurant = queryFactory.selectFrom(restaurant).where(restaurant.id.eq(restaurantId)).fetchOne();
//
//        if (foundUser != null && foundRestaurant != null) {
//            newReview.setUser(foundUser);
//            newReview.setRestaurant(foundRestaurant);
//
//            // 리뷰 객체 저장
//            entityManager.persist(newReview);
//        }
//
//        return newReview;
//    }
//}
