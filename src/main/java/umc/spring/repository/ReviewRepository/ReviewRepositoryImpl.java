package umc.spring.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QReview;
import umc.spring.domain.QMember;
import umc.spring.domain.QStore;
import umc.spring.domain.Review;
import umc.spring.domain.Member;
import umc.spring.domain.Store;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory; // JPAQueryFactory 주입
    private final QReview review = QReview.review;
    private final QMember member = QMember.member;
    private final QStore store = QStore.store;

    // 사용자 ID로 리뷰를 조회하는 메서드
    @Override
    public List<Review> findReviewsByMemberId(Long memberId) {
        return queryFactory
                .selectFrom(review)
                .join(review.member, member)
                .where(member.id.eq(memberId))
                .fetch();
    }

    // 새로운 리뷰 등록하는 메서드
    @Override
    public Review createReview(Long memberId, Long storeId, Float rating, String content) {
        // 새로운 Review 객체 생성
        Review newReview = Review.builder()
                .member(member)
                .store(store)
                .rating(rating)
                .content(content)
                .build();

        // 실제 Member와 Store을 DB에서 조회하여 set
        Member foundMember = queryFactory.selectFrom(member).where(member.id.eq(memberId)).fetchOne();
        Store foundStore = queryFactory.selectFrom(store).where(store.id.eq(storeId)).fetchOne();

        if (foundMember != null && foundStore != null) {
            newReview.setMember(foundMember);
            newReview.setStore(foundStore);

            // 리뷰 객체 저장
            entityManager.persist(newReview);
        }

        return newReview;
    }
}
