package dcom.homepage.api.domain.users.service;

import dcom.homepage.api.domain.users.dto.Token;
import dcom.homepage.api.domain.users.dto.UserTokenDto;

public interface TokenService {
    Token generateToken(UserTokenDto userDto);
    UserTokenDto verifyToken(String token, boolean isAccess);
}
