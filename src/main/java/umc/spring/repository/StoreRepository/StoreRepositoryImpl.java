//package umc.spring.repository.StoreRepository;
//
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import umc.spring.domain.Store;
//import umc.spring.domain.QStore;
//
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class StoreRepositoryImpl implements StoreRepositoryCustom{
//    private final JPAQueryFactory jpaQueryFactory;
//    private final QStore Store = QStore.store;
//
//    @Override
//    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {
//        BooleanBuilder predicate = new BooleanBuilder();
//
//        if (name != null) {
//            predicate.and(Store.name.eq(name));
//        }
//
//        if (score != null) {
//            predicate.and(Store.score.goe(4.0f));
//        }
//
//        return jpaQueryFactory
//                .selectFrom(Store)
//                .where(predicate)
//                .fetch();
//    }
//}