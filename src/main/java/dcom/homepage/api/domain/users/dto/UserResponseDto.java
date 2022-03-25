package dcom.homepage.api.domain.users.dto;

import dcom.homepage.api.domain.group.Group;
import dcom.homepage.api.domain.users.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserResponseDto {
    @ApiModel(value = "유저 프로필 정보")
    @Builder
    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class Profile {
        private final Integer id;
        private final String userId;
        private final Integer admissionYear;
        private final String realName;
        private final String github;
        private final String homepage;
        private final Set<Group> groups;

        public static Profile of(User user) {
            return Profile.builder()
                    .id(user.getId())
                    .userId(user.getUserId())
                    .admissionYear(user.getAdmissionYear())
                    .realName(user.getRealName())
                    .github(user.getGithub())
                    .homepage(user.getHomepage())
                    .groups(user.getGroups())
                    .build();
        }

        public static List<Profile> of(List<User> userProfileDtoList) {
            return userProfileDtoList.stream()
                    .map(Profile::of)
                    .collect(Collectors.toList());
        }
    }

    @ApiModel(value = "유저 프로필 정보")
    @Builder
    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class SimpleProfile {
        private final String userId;
        private final Integer admissionYear;
        private final String realName;

        public static SimpleProfile of(User user) {
            return SimpleProfile.builder()
                    .userId(user.getUserId())
                    .admissionYear(user.getAdmissionYear())
                    .realName(user.getRealName())
                    .build();
        }

        public static List<SimpleProfile> of(List<User> userSimpleProfileDtoList) {
            return userSimpleProfileDtoList.stream()
                    .map(SimpleProfile::of)
                    .collect(Collectors.toList());
        }
    }

    @ApiModel(value = "유저 회원 가입 정보")
    @Builder
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Token {
        @ApiModelProperty(value = "유저 아이디")
        private String token;
    }
}
