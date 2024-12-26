package umc.spring.web.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistMembers;
import umc.spring.validation.annotation.ExistMissions;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotBlank
        @Email
        String email;    // 이메일 필드 추가
        @NotBlank
        String password;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @NotNull
        Integer age;
        @Size(min=5, max=12)
        String address;
        @Size(min=5, max=12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
        @NotNull
        Role role;
    }

    @Getter
    public static class ChallengeMissionDto{
        @ExistMembers
        Long memberId;
        @ExistMissions
        Long missionId;
    }

    @Getter
    public static class CompleteMissionDto{
        @ExistMembers
        Long memberId;
        @ExistMissions
        Long missionId;
        Long memberMissionId;
    }
}