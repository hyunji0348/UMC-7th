package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission is a Querydsl query type for Mission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission extends EntityPathBase<Mission> {

    private static final long serialVersionUID = -453449888L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMission mission = new QMission("mission");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DatePath<java.time.LocalDate> deadline = createDate("deadline", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final ListPath<umc.spring.domain.mapping.MemberMission, umc.spring.domain.mapping.QMemberMission> memberMissionList = this.<umc.spring.domain.mapping.MemberMission, umc.spring.domain.mapping.QMemberMission>createList("memberMissionList", umc.spring.domain.mapping.MemberMission.class, umc.spring.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final StringPath missionSpec = createString("missionSpec");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final QRegion region;

    public final NumberPath<Integer> reward = createNumber("reward", Integer.class);

    public final EnumPath<umc.spring.domain.enums.MissionStatus> status = createEnum("status", umc.spring.domain.enums.MissionStatus.class);

    public final QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMission(String variable) {
        this(Mission.class, forVariable(variable), INITS);
    }

    public QMission(Path<? extends Mission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMission(PathMetadata metadata, PathInits inits) {
        this(Mission.class, metadata, inits);
    }

    public QMission(Class<? extends Mission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

