package umc.spring.repository.UserRepository;

import umc.spring.domain.User;
import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<User> findUserByDynamicCondition(Long userId);
}
