//package umc.spring.repository.MissionRepository;
//
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import umc.spring.domain.QMission;
//import umc.spring.domain.QStore;
//import umc.spring.domain.QMember;
//import umc.spring.domain.mapping.QMemberMission;
//import umc.spring.domain.mapping.MemberMission;
//
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class MissionRepositoryImpl implements MissionRepositoryCustom {
//    private final JPAQueryFactory queryFactory;
//    private final QMemberMission memberMission = QMemberMission.memberMission;
//    private final QMission mission = QMission.mission;
//    private final QStore restaurant = QStore.restaurant;
//    private final QMember member = QMember.member;
//
//    private static final int PAGE_SIZE = 10;
//
//    // 진행 중인 미션 조회
//    @Override
//    public List<MemberMission> findInProgressMissions(Long memberId, int page) {
//        BooleanBuilder predicate = new BooleanBuilder();
//
//        if (memberId != null) {
//            predicate.and(memberMission.member.id.eq(memberId));
//        }
//
//        predicate.and(memberMission.completion.isFalse()); // 진행 중인 미션만 조회
//
//        return queryFactory
//                .selectFrom(memberMission)
//                .join(memberMission.mission, mission)
//                .join(mission.store, store)
//                .join(memberMission.member, member)
//                .where(predicate)
//                .orderBy(mission.dDay.asc())
//                .offset((page - 1) * PAGE_SIZE)
//                .limit(PAGE_SIZE)
//                .fetch();
//    }
//
//    // 완료된 미션 조회
//    @Override
//    public List<MemberMission> findCompletedMissions(Long memberId, int page) {
//        BooleanBuilder predicate = new BooleanBuilder();
//
//        if (memberId != null) {
//            predicate.and(memberMission.member.id.eq(memberId));
//        }
//
//        predicate.and(memberMission.completion.isTrue()); // 완료된 미션만 조회
//
//        return queryFactory
//                .selectFrom(memberMission)
//                .join(memberMission.mission, mission)
//                .join(mission.restaurant, restaurant)
//                .join(memberMission.member, member)
//                .where(predicate)
//                .orderBy(mission.dDay.asc())
//                .offset((page - 1) * PAGE_SIZE)
//                .limit(PAGE_SIZE)
//                .fetch();
//    }
//
//    @Override
//    public List<MemberMission> findCurrentInProgressMissions(Long memberId) {
//        BooleanBuilder predicate = new BooleanBuilder();
//
//        if (memberId != null) {
//            predicate.and(memberMission.member.id.eq(memberId));
//        }
//
//        predicate.and(memberMission.completion.isFalse());
//
//        return queryFactory
//                .selectFrom(memberMission)
//                .join(memberMission.mission, mission)
//                .join(mission.restaurant, restaurant)
//                .join(memberMission.member, member)
//                .where(predicate)
//                .orderBy(mission.dDay.asc())
//                .limit(5)
//                .fetch();
//    }
//}
