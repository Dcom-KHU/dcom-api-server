package dcom.homepage.api.domain.users.dto;

import dcom.homepage.api.domain.group.Group;
import dcom.homepage.api.domain.group.dto.GroupResponseDto;
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
    @AllArgsConstructor
    public static class Profile {
        private Integer id;
        private String userId;
        private Integer admissionYear;
        private String realName;
        private String github;
        private String homepage;
        private String description;
        private Set<GroupResponseDto.SimpleInfo> groups;

        public static Profile of(User user) {
            return Profile.builder()
                    .id(user.getId())
                    .userId(user.getUserId())
                    .admissionYear(user.getAdmissionYear())
                    .realName(user.getRealName())
                    .github(user.getGithub())
                    .homepage(user.getHomepage())
                    .description(user.getDescription())
                    .groups(GroupResponseDto.SimpleInfo.of(user.getGroups()))
                    .build();
        }

        public static List<Profile> of(List<User> userProfileDtoList) {
            return userProfileDtoList.stream()
                    .map(Profile::of)
                    .collect(Collectors.toList());
        }

        public static Set<Profile> of(Set<User> userProfileDtoList) {
            return userProfileDtoList.stream()
                    .map(Profile::of)
                    .collect(Collectors.toSet());
        }
    }

    @ApiModel(value = "유저 프로필 정보")
    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    public static class SimpleProfile {
        private String userId;
        private Integer admissionYear;
        private String realName;

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

        public static Set<SimpleProfile> of(Set<User> userSimpleProfileDtoList) {
            return userSimpleProfileDtoList.stream()
                    .map(SimpleProfile::of)
                    .collect(Collectors.toSet());
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
