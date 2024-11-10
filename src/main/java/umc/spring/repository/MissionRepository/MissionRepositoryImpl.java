package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMission;
import umc.spring.domain.QRestaurant;
import umc.spring.domain.QUser;
import umc.spring.domain.mapping.QUserMission;
import umc.spring.domain.mapping.UserMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QUserMission userMission = QUserMission.userMission;
    private final QMission mission = QMission.mission;
    private final QRestaurant restaurant = QRestaurant.restaurant;
    private final QUser user = QUser.user;

    private static final int PAGE_SIZE = 10;

    // 진행 중인 미션 조회
    @Override
    public List<UserMission> findInProgressMissions(Long userId, int page) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (userId != null) {
            predicate.and(userMission.user.id.eq(userId));
        }

        predicate.and(userMission.completion.isFalse()); // 진행 중인 미션만 조회

        return queryFactory
                .selectFrom(userMission)
                .join(userMission.mission, mission)
                .join(mission.restaurant, restaurant)
                .join(userMission.user, user)
                .where(predicate)
                .orderBy(mission.dDay.asc())
                .offset((page - 1) * PAGE_SIZE)
                .limit(PAGE_SIZE)
                .fetch();
    }

    // 완료된 미션 조회
    @Override
    public List<UserMission> findCompletedMissions(Long userId, int page) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (userId != null) {
            predicate.and(userMission.user.id.eq(userId));
        }

        predicate.and(userMission.completion.isTrue()); // 완료된 미션만 조회

        return queryFactory
                .selectFrom(userMission)
                .join(userMission.mission, mission)
                .join(mission.restaurant, restaurant)
                .join(userMission.user, user)
                .where(predicate)
                .orderBy(mission.dDay.asc())
                .offset((page - 1) * PAGE_SIZE)
                .limit(PAGE_SIZE)
                .fetch();
    }

    @Override
    public List<UserMission> findCurrentInProgressMissions(Long userId) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (userId != null) {
            predicate.and(userMission.user.id.eq(userId));
        }

        predicate.and(userMission.completion.isFalse());

        return queryFactory
                .selectFrom(userMission)
                .join(userMission.mission, mission)
                .join(mission.restaurant, restaurant)
                .join(userMission.user, user)
                .where(predicate)
                .orderBy(mission.dDay.asc())
                .limit(5)
                .fetch();
    }
}
