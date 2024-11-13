package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.User;
import umc.spring.repository.UserRepository.UserRepository;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    @Override
    public Optional<User> getUserProfile(Long userId) {
        return userRepository.findUserByDynamicCondition(userId);
    }
}
