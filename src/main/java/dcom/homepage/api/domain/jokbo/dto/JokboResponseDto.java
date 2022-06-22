package dcom.homepage.api.domain.jokbo.dto;

import com.querydsl.core.annotations.QueryProjection;
import dcom.homepage.api.domain.jokbo.Jokbo;
import dcom.homepage.api.domain.jokbo.JokboContent;
import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserResponseDto;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

public class JokboResponseDto {
    @ApiModel(value = "족보 목록형 DTO")
    @Getter
    @Setter
    public static class Simple {
        private Integer id;
        private UserResponseDto.SimpleProfile writer;
        private String professor;
        private String course;
        private LocalDateTime recentUpload;
        private Integer contentCount;

        @Builder
        @QueryProjection
        public Simple(Integer id, User writer, String professor, String course, LocalDateTime recentUpload, Integer contentCount) {
            this.id = id;
            this.writer = UserResponseDto.SimpleProfile.of(writer);
            this.professor = professor;
            this.course = course;
            this.recentUpload = recentUpload;
            this.contentCount = contentCount;
        }
    }

    @ApiModel(value = "족보 상세 DTO")
    @Getter @Setter
    public static class Info {
        private Integer id;
        private UserResponseDto.SimpleProfile writer;
        private String professor;
        private String course;
        private LocalDateTime recentUpload;
        private Integer contentCount;
        private Set<JokboContentResponseDto> contents;

        @Builder
        @QueryProjection
        public Info(Integer id, User writer, String professor, String course, LocalDateTime recentUpload, Integer contentCount, Set<JokboContent> contents) {
            this.id = id;
            this.writer = UserResponseDto.SimpleProfile.of(writer);
            this.professor = professor;
            this.course = course;
            this.recentUpload = recentUpload;
            this.contentCount = contentCount;
            this.contents = JokboContentResponseDto.of(contents);
        }

        public static Info of(Jokbo jokbo) {
            return Info.builder()
                    .id(jokbo.getId())
                    .writer(jokbo.getWriter())
                    .professor(jokbo.getProfessor())
                    .course(jokbo.getCourse())
                    .recentUpload(jokbo.getRecentUpload())
                    .contentCount(jokbo.getContentCount())
                    .contents(jokbo.getContents())
                    .build();
        }
    }
}
