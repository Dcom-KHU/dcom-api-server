package dcom.homepage.api.domain.users.dto;

import dcom.homepage.api.domain.users.User;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

public class UserRequestDto {
    @Builder
    @Getter @Setter
    @RequiredArgsConstructor
    public static class Login {
        private final String userId;
        private final String password;
    }
}
