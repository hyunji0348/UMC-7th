package umc.spring.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.UserMission;

public interface MissionRepository extends JpaRepository<UserMission, Long>, MissionRepositoryCustom {
}
