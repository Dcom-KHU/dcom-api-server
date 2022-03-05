package dcom.homepage.api.domain.users.service;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserLoginDto;
import dcom.homepage.api.domain.users.dto.UserProfileDto;
import java.util.Optional;

public interface UserService {
    Optional<UserProfileDto> getProfileByUserId(String userId);
    Optional<User> login(UserLoginDto userLoginDto);
}
