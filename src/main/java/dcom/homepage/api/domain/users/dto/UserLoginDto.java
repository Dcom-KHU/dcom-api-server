package dcom.homepage.api.domain.users.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@RequiredArgsConstructor
public class UserLoginDto {
    private final String userId;
    private final String password;
}
