package dcom.homepage.api.domain.user;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserLoginDto;
import dcom.homepage.api.domain.users.repository.UserRepository;
import dcom.homepage.api.domain.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootTest
public class UserAuthTest {

    @Autowired
    private UserService userService;

    @Test
    public void 유저_로그인() {
        // given (본인 아이디, 패스워드 필요)
        UserLoginDto userLoginDto = UserLoginDto.builder()
                .userId("test")
                .password("test")
                .build();

        // when
        User user = userService.login(userLoginDto);

        // then
        Assertions.assertThat(user).isNotNull();
    }
}
