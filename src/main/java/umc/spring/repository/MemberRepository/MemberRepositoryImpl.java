//package umc.spring.repository.MemberRepository;
//
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import umc.spring.domain.Member;
//import umc.spring.domain.QMember;
//
//import java.util.Optional;
//
//@Repository
//@RequiredArgsConstructor
//public class MemberRepositoryImpl implements MemberRepositoryCustom {
//    private final JPAQueryFactory jpaQueryFactory;
//    private final QMember member = QMember.member;
//
//    @Override
//    public Optional<Member> findMemberByDynamicCondition(Long memberId) {
//        BooleanBuilder predicate = new BooleanBuilder();
//
//        if (memberId != null) {
//            predicate.and(member.id.eq(memberId));
//        }
//
//        Member result = jpaQueryFactory
//                .selectFrom(member)
//                .where(predicate)
//                .fetchOne();
//
//        return Optional.ofNullable(result); // Optional로 반환
//    }
//}