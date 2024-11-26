package umc.spring.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class StoreDto{
        @NotBlank
        String name;
        @Size(min=5, max=12)
        String address;
        @NotNull
        Float score;
        List<Long> reviewList;
    }

    @Getter
    public static class ReviewDto {
        @NotBlank
        String title;
        @NotNull
        Float score;
        @NotBlank
        String content;
    }

    @Getter
    public static class MissionDto{
        @NotNull
        Integer reward;
        @NotNull
        Integer price;
        @NotNull
        LocalDate deadline;
        @NotEmpty
        String missionSpec;
    }

}