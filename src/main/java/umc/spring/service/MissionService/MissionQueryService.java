package umc.spring.service.MissionService;

import umc.spring.domain.mapping.UserMission;

import java.util.List;

public interface MissionQueryService {
    List<UserMission> getInProgressMissions(Long userId, int page);
    List<UserMission> getCompletedMissions(Long userId, int page);
    List<UserMission> getCurrentInProgressMissions(Long userId);
}