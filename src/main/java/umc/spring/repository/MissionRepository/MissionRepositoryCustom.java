package umc.spring.repository.MissionRepository;

import umc.spring.domain.mapping.UserMission;
import java.util.List;

public interface MissionRepositoryCustom {
    List<UserMission> findInProgressMissions(Long userId, int page);
    List<UserMission> findCompletedMissions(Long userId, int page);
    List<UserMission> findCurrentInProgressMissions(Long userId);
}