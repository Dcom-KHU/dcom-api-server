package dcom.homepage.api.domain.studycommits.dto;

import dcom.homepage.api.domain.studycommits.StudyCommit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;


public class StudyCommitResponseDto {

    @ApiModel(value = "스터디 커밋 정보")
    @Builder
    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    public static class Simple {
        @ApiModelProperty(value = "커밋 아이디")
        private Long id;

        @ApiModelProperty(value = "커밋 일자")
        private Date summitDate;

        @ApiModelProperty(value = "유저 아이디")
        private String userId;

        @ApiModelProperty(value = "스터디 아이디")
        private Integer studyId;

        public static Simple of(StudyCommit studyCommit) {
            return Simple.builder()
                    .id(studyCommit.getId())
                    .summitDate(studyCommit.getSummitDate())
                    .userId(studyCommit.getUser().getUserId())
                    .studyId(studyCommit.getStudy().getId())
                    .build();
        }
    }
}
