package umc.spring.web.dto;

import lombok.Getter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
public class StoreRequestDTO {

    @Getter
    public static class StoreDto{
        @NotBlank
        String name;
        @Size(min=2, max=12)
        String address;
        @NotNull
        Float score;
//        @ExistRegion
//        Long regionId;
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
        private Integer reward;
        @NotNull
        private Integer price;
        @NotNull
        private LocalDate deadline;
    }
}