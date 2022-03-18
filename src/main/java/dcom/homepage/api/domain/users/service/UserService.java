package dcom.homepage.api.domain.users.service;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserRequestDto;
import dcom.homepage.api.domain.users.dto.UserResponseDto;

public interface UserService {
    UserResponseDto.Profile getProfileByUserId(String userId);
    UserResponseDto.Profile register(UserRequestDto.Register userDto);
    String login(UserRequestDto.Login userDto);
    User getUserWithAuthorities(String username);
    User getMyUserWithAuthorities();
    boolean equalsPassword(String password, String encryptedPassword);
}
