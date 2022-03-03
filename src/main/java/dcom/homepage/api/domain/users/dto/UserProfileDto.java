package dcom.homepage.api.domain.users.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
}
