package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<MemberMission> getInProgressMissions(Long userId, int page) {
        return missionRepository.findInProgressMissions(userId, page);
    }
    @Override
    public List<MemberMission> getCompletedMissions(Long userId, int page) {
        return missionRepository.findCompletedMissions(userId, page);
    }
    @Override
    public List<MemberMission> getCurrentInProgressMissions(Long userId) {
        return missionRepository.findCurrentInProgressMissions(userId);
    }
}

