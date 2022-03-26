package dcom.homepage.api.domain.study.dto;

import dcom.homepage.api.domain.study.StudyType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class StudyRequestDto {
    @ApiModel(value = "스터디 등록 정보")
    @Builder
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Make {
        @NotEmpty @Size(min = 4, max = 256, message = "길이는 4 ~ 256자를 허용 합니다.")
        @ApiModelProperty(value = "스터디 이름", required = true)
        private String name;

        @NotEmpty
        @ApiModelProperty(value = "스터디 유형", required = true)
        private StudyType type;

        @ApiModelProperty(value = "스터디 설명")
        private String description;

        @ApiModelProperty(value = "스터디 시작 일자")
        private Date startDate;

        @ApiModelProperty(value = "스터디 종료 일자")
        private Date endDate;

        @ApiModelProperty(value = "스터디 주기, null 일시 주기 비활성화")
        private Integer cycle;
    }
}
