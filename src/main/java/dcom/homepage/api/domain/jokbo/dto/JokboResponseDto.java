package dcom.homepage.api.domain.jokbo.dto;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserResponseDto;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
        public Simple(Integer id, User writer, String professor, String course, LocalDateTime recentUpload, Integer contentCount) {
            this.id = id;
            this.writer = UserResponseDto.SimpleProfile.of(writer);
            this.professor = professor;
            this.course = course;
            this.recentUpload = recentUpload;
            this.contentCount = contentCount;
        }
    }
}
