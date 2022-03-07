package dcom.homepage.api.domain.users.service;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.Token;
import dcom.homepage.api.domain.users.dto.UserLoginDto;
import dcom.homepage.api.domain.users.dto.UserProfileDto;
import dcom.homepage.api.domain.users.dto.UserTokenDto;

import java.util.Optional;

public interface AuthenticationService {
    Token login(UserLoginDto userLoginDto);
    User findByToken(String token);
    UserTokenDto verifyToken(String token);
}
