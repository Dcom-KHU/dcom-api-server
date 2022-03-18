package dcom.homepage.api.domain.users.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


public class UserRequestDto {

    @Builder
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Login {

        @ApiModelProperty(value = "유저 아이디")
        private String userId;

        @ApiModelProperty(value = "비밀 번호")
        private String password;
    }

    @ApiModel(value = "유저 회원 가입 정보")
    @Builder
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Register {

        @ApiModelProperty(value = "유저 아이디")
        private String userId;

        @ApiModelProperty(value = "학번", required = true)
        private Integer admissionYear;

        @ApiModelProperty(value = "별명", required = true)
        private String nickname;

        @ApiModelProperty(value = "이메일", required = true)
        private String email;

        @ApiModelProperty(value = "전화 번호", required = true)
        private String phone;

        @ApiModelProperty(value = "비밀 번호", required = true)
        private String password;

        @ApiModelProperty(value = "이름", required = true)
        private String realName;

        @ApiModelProperty(value = "GitHub 닉네임", required = false)
        private String github;

        @ApiModelProperty(value = "개인 홈페이지", required = false)
        private String homepage;
    }
}
