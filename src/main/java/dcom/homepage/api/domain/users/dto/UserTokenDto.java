package dcom.homepage.api.domain.users.dto;

import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor
public class UserTokenDto {
    private String userId;
    private String realName;
}
