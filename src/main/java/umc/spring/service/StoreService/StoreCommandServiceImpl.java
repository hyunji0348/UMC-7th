package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.StoreConverter;
import umc.spring.converter.StoreMissionConverter;
import umc.spring.converter.StoreReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.*;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.MissionRepository.MissionRepository;


@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService {

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Store joinStore(Long regionId, StoreRequestDTO.StoreDto request) {
        Store newStore = StoreConverter.toStore(request);

        newStore.setRegion(regionRepository.findById(regionId).get());
        return storeRepository.save(newStore);
    }

    @Override
    public Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDto request) {
        Review newReview = StoreReviewConverter.toReview(request);

        newReview.setMember(memberRepository.findById(memberId).get());
        newReview.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(newReview);
    }

    @Override
    public Mission createMission(Long storeId, StoreRequestDTO.MissionDto request) {
        Mission newMission = StoreMissionConverter.toMission(request);

        newMission.setStore(storeRepository.findById(storeId).get());

        return missionRepository.save(newMission);
    }


}