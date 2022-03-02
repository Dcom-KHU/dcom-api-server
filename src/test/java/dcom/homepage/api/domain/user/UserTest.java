package dcom.homepage.api.domain.user;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void 유저조회() {
        // given
        final Integer id = 1;

        // when
        User user = userRepository.findById(1).get();

        // then
        Assertions.assertThat(user.getRealName()).isEqualTo("디닷컴");
    }
}
