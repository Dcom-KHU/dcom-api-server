package dcom.homepage.api.domain.jokbo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class JokboRequestDto {
    @ApiModel(value = "검색 타입을 나타냄. 각각 전체, 교수, 강좌")
    public enum SearchType {
        ALL, PROFESSOR, COURSE
    }

    @ApiModel(value = "족보 검색 쿼리 DTO")
    @Getter @Setter
    public static class Search {
        @ApiModelProperty(value = "검색어", required = true)
        private String query;

        @ApiModelProperty(value = "검색 타입", required = true)
        private SearchType searchType;

        @ApiModelProperty(value = "페이지 번호, 0부터 시작", required = true)
        @PositiveOrZero
        private Integer page;

        @ApiModelProperty(value = "페이지당 보여지는 족보 갯수", required = true)
        @Positive
        private Integer pageSize;
    }

    @ApiModel(value = "족보 등록 DTO")
    public static class Post {

        @ApiModelProperty(value = "교수명", required = true)
        private String professor;

        @ApiModelProperty(value = "강좌명", required = true)
        private String course;
    }
}
