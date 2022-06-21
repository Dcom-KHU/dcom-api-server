package dcom.homepage.api.domain.jokbo.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dcom.homepage.api.domain.jokbo.Jokbo;
import dcom.homepage.api.domain.jokbo.dto.JokboRequestDto;
import dcom.homepage.api.domain.jokbo.dto.JokboResponseDto;
import dcom.homepage.api.domain.jokbo.dto.QJokboResponseDto_Simple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static dcom.homepage.api.domain.jokbo.QJokbo.jokbo;

@RequiredArgsConstructor
@Repository
public class JokboQueryRepository {
    private final JPAQueryFactory queryFactory;

    public Page<JokboResponseDto.Simple> searchAll(JokboRequestDto.Search search, Pageable pageable) {
        List<JokboResponseDto.Simple> results = queryFactory.select(new QJokboResponseDto_Simple(
                jokbo.id,
                jokbo.writer,
                jokbo.professor,
                jokbo.course,
                jokbo.recentUpload,
                jokbo.contentCount
            ))
            .from(jokbo)
            .where(searchCondition(search))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        JPAQuery<Long> query = queryFactory.select(Wildcard.count).from(jokbo).where(searchCondition(search));

        return PageableExecutionUtils.getPage(results, pageable, () -> query.fetch().get(0));
    }

    private BooleanExpression searchCondition(JokboRequestDto.Search search) {
        switch (search.getSearchType()) {
            case ALL:
                return jokbo.professor.contains(search.getQuery()).or(jokbo.course.contains(search.getQuery()));
            case COURSE:
                return jokbo.course.contains(search.getQuery());
            case PROFESSOR:
                return jokbo.professor.contains(search.getQuery());
            default:
                return null;
        }
    }
}
