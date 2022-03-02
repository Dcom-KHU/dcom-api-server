package dcom.homepage.api.domain.users.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class UserLoginDto {
    private String userId;
    private String password;
}
