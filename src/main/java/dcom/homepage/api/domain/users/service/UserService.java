package dcom.homepage.api.domain.users.service;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserRequestDto;
import dcom.homepage.api.domain.users.dto.UserResponseDto;

public interface UserService {
    UserResponseDto.Profile getProfileByUserId(String userId);
    void save(User user);
    boolean equalsPassword(String password, String encryptedPassword);
}
