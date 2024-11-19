package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.validation.annotation.ExistRegion;
import umc.spring.validation.annotation.ExistStores;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RegionsExistValidator implements ConstraintValidator<ExistRegion, Object> {

    private final RegionRepository regionRepository;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // null 값 허용 시
        }

        if (value instanceof Long) {
            return regionRepository.existsById((Long) value);
        } else if (value instanceof List) {
            @SuppressWarnings("unchecked")
            List<Long> values = (List<Long>) value;
            boolean isValid = values.stream()
                    .allMatch(regionRepository::existsById);

            if (!isValid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("존재하지 않는 지역이 포함되어 있습니다.")
                        .addConstraintViolation();
            }
            return isValid;
        }
        return false;
    }
}
