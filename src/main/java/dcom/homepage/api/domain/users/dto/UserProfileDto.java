package dcom.homepage.api.domain.users.dto;

import dcom.homepage.api.domain.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter @Setter
@RequiredArgsConstructor
public class UserProfileDto {
    private final Integer id;
    private final String userId;
    private final Integer admissionYear;
    private final String realName;
    private final String github;
    private final String homepage;

    public static UserProfileDto of(User user) {
        return UserProfileDto.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .admissionYear(user.getAdmissionYear())
                .realName(user.getRealName())
                .github(user.getGithub())
                .homepage(user.getHomepage())
                .build();
    }

    public static List<UserProfileDto> of(List<User> userProfileDtoList) {
        return userProfileDtoList.stream()
                .map(UserProfileDto::of)
                .collect(Collectors.toList());
    }
}
