package dcom.homepage.api.domain.users.service;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserLoginDto;
import dcom.homepage.api.domain.users.dto.UserProfileDto;
import dcom.homepage.api.global.exceptions.NotFoundException;

import java.util.Optional;

public interface UserService {
    UserProfileDto getProfileByUserId(String userId);
    void save(User user);
    boolean equalsPassword(String password, String encryptedPassword);
}
