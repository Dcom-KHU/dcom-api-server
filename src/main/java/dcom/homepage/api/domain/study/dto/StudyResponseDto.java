package dcom.homepage.api.domain.study.dto;

import dcom.homepage.api.domain.study.Study;
import dcom.homepage.api.domain.study.StudyType;
import dcom.homepage.api.domain.users.dto.UserResponseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class StudyResponseDto {
    @ApiModel(value = "리스트 용 스터디 정보")
    @Builder
    @Getter @Setter
    @AllArgsConstructor
    public static class SimpleInfo {
        @ApiModelProperty(value = "스터디 아이디")
        private Integer id;

        @ApiModelProperty(value = "스터디 이름")
        private String name;

        @ApiModelProperty(value = "스터디 유형")
        private StudyType type;

        @ApiModelProperty(value = "스터디 설명")
        private String description;

        @ApiModelProperty(value = "스터디 소유자")
        private UserResponseDto.SimpleProfile owner;

        @ApiModelProperty(value = "스터디 생성 일자")
        private Date createdAt;

        @ApiModelProperty(value = "스터디 시작 일자")
        private Date startDate;

        @ApiModelProperty(value = "스터디 종료 일자")
        private Date endDate;

        @ApiModelProperty(value = "스터디 주기")
        private Integer cycle;

        public static SimpleInfo of(Study study) {
            return SimpleInfo.builder()
                    .id(study.getId())
                    .name(study.getName())
                    .type(study.getType())
                    .description(study.getDescription())
                    .owner(UserResponseDto.SimpleProfile.of(study.getOwner()))
                    .createdAt(study.getCreatedAt())
                    .startDate(study.getStartDate())
                    .endDate(study.getEndDate())
                    .cycle(study.getCycle())
                    .build();
        }
    }

    @ApiModel(value = "전체 스터디 정보")
    @Builder
    @Getter @Setter
    @AllArgsConstructor
    public static class Info {
        @ApiModelProperty(value = "스터디 아이디")
        private Integer id;

        @ApiModelProperty(value = "스터디 이름")
        private String name;

        @ApiModelProperty(value = "스터디 유형")
        private StudyType type;

        @ApiModelProperty(value = "스터디 설명")
        private String description;

        @ApiModelProperty(value = "스터디 소유자")
        private UserResponseDto.SimpleProfile owner;

        @ApiModelProperty(value = "스터디 관리자")
        private List<UserResponseDto.SimpleProfile> admin;

        @ApiModelProperty(value = "스터디 참여 인원")
        private List<UserResponseDto.SimpleProfile> users;

        @ApiModelProperty(value = "스터디 신청 유저")
        private List<UserResponseDto.SimpleProfile> pendingUsers;

        @ApiModelProperty(value = "스터디 생성 일자")
        private Date createdAt;

        @ApiModelProperty(value = "스터디 시작 일자")
        private Date startDate;

        @ApiModelProperty(value = "스터 종료 일자")
        private Date endDate;

        @ApiModelProperty(value = "스터디 휴식 시작 일자")
        private Date vacationStartDate;

        @ApiModelProperty(value = "스터디 휴식 종료 일자")
        private Date vacationEndDate;

        @ApiModelProperty(value = "스터디 주기")
        private Integer cycle;

        public static Info of(Study study) {
            return Info.builder()
                    .id(study.getId())
                    .name(study.getName())
                    .type(study.getType())
                    .description(study.getDescription())
                    .owner(UserResponseDto.SimpleProfile.of(study.getOwner()))
                    .admin(study.getAdmin()
                            .stream()
                            .map(UserResponseDto.SimpleProfile::of)
                            .collect(Collectors.toList()))
                    .users(study.getUsers()
                            .stream()
                            .map(UserResponseDto.SimpleProfile::of)
                            .collect(Collectors.toList()))
                    .pendingUsers(study.getPendingUsers()
                            .stream()
                            .map(UserResponseDto.SimpleProfile::of)
                            .collect(Collectors.toList()))
                    .createdAt(study.getCreatedAt())
                    .startDate(study.getStartDate())
                    .endDate(study.getEndDate())
                    .vacationStartDate(study.getVacationStartDate())
                    .vacationEndDate(study.getVacationEndDate())
                    .cycle(study.getCycle())
                    .build();
        }
    }
}
