package umc.spring.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Restaurant;
import umc.spring.domain.QRestaurant;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QRestaurant Restaurant = QRestaurant.restaurant;

    @Override
    public List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(Restaurant.name.eq(name));
        }

        if (score != null) {
            predicate.and(Restaurant.rating.goe(4.0f));
        }

        return jpaQueryFactory
                .selectFrom(Restaurant)
                .where(predicate)
                .fetch();
    }
}