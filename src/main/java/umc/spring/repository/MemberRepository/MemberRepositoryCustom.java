package umc.spring.repository.MemberRepository;

import umc.spring.domain.Member;
import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> findMemberByDynamicCondition(Long memberId);  // 의미 있는 이름 사용
}
