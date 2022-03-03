package dcom.homepage.api.domain.user;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserProfileDto;
import dcom.homepage.api.domain.users.repository.UserRepository;
import dcom.homepage.api.domain.users.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void test유저조회() {
        Optional<UserProfileDto> userProfileDto = userService.getProfileByUserId("dcom");
        Assertions.assertThat(userProfileDto.get().getUserId()).isEqualTo("dcom");
    }
}
