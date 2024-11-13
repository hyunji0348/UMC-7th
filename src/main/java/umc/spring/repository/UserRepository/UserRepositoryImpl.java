package umc.spring.repository.UserRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QUser;
import umc.spring.domain.User;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QUser user = QUser.user;

    @Override
    public Optional<User> findUserByDynamicCondition(Long userId) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (userId != null) {
            predicate.and(user.id.eq(userId));
        }

        User result = jpaQueryFactory
                .selectFrom(user)
                .where(predicate)
                .fetchOne();

        return Optional.ofNullable(result); // Optional로 반환
    }
}