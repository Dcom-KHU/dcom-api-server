package dcom.homepage.api.domain.users.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;


public class UserRequestDto {
    @ApiModel(value = "유저 로그인 정보")
    @Builder
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Login {

        @NotEmpty @Size(min = 4, max = 20, message = "길이는 4 ~ 20자를 허용 합니다.")
        @ApiModelProperty(value = "유저 아이디")
        private String userId;

        @NotEmpty @Size(min = 5, max = 20, message = "비밀 번호는 5자 부터 20자를 허용 합니다.")
        @ApiModelProperty(value = "비밀 번호")
        private String password;
    }

    @ApiModel(value = "유저 회원 가입 정보")
    @Builder
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Register {

        @NotEmpty @Size(min = 4, max = 20, message = "길이는 4 ~ 20자를 허용 합니다.")
        @ApiModelProperty(value = "유저 아이디")
        private String userId;

        @NotEmpty @Max(value = 99, message = "2자릿 수만 허용 합니다.") @Min(value = 10, message = "2자릿 수만 허용 합니다.")
        @ApiModelProperty(value = "학번", required = true)
        private Integer admissionYear;

        @NotEmpty @Email
        @ApiModelProperty(value = "이메일", required = true)
        private String email;

        @NotEmpty @Pattern(regexp = "\\d{3}-\\d{3,4}-\\d{4}", message = "전화 번호가 일치 하지 않습니다.")
        @ApiModelProperty(value = "전화 번호", required = true)
        private String phone;

        @NotEmpty @Size(min = 5, max = 20, message = "비밀 번호는 5자 부터 20자를 허용 합니다.")
        @ApiModelProperty(value = "비밀 번호", required = true)
        private String password;

        @NotEmpty @Size(min = 2, max = 20, message = "이름은 2자부터 20자를 허용 합니다.")
        @ApiModelProperty(value = "이름", required = true)
        private String realName;

        @Size(min = 2, max = 20, message = "GitHub 이름은 2자부터 20자를 허용 합니다.")
        @ApiModelProperty(value = "GitHub 닉네임", required = false)
        private String github;

        @URL
        @ApiModelProperty(value = "개인 홈페이지", required = false)
        private String homepage;
    }
}
