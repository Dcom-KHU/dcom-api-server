package dcom.homepage.api.domain.users.dto;

import dcom.homepage.api.domain.group.Group;
import dcom.homepage.api.domain.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserResponseDto {
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
}
