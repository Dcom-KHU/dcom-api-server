package dcom.homepage.api.domain.users.service;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.Token;
import dcom.homepage.api.domain.users.dto.UserLoginDto;
import dcom.homepage.api.domain.users.dto.UserTokenDto;
import dcom.homepage.api.domain.users.repository.UserRepository;
import dcom.homepage.api.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenAuthenticationService implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Override
    public Token login(UserLoginDto userLoginDto) {
        String userId = userLoginDto.getUserId();
        String password = userLoginDto.getPassword();

        User user = userRepository.findByUserId(userId).orElseThrow(
                () -> new IllegalAccessError("아이디 혹은 비밀 번호가 정확하지 않습니다.")
        );
        String realName = user.getRealName();
        String current_password = user.getPassword();
        if (passwordEncoder.matches(password, current_password)) {
            return tokenService.generateToken(UserTokenDto.builder()
                    .userId(userId)
                    .realName(realName)
                    .build()
            );
        } else {
            throw new IllegalAccessError("아이디 혹은 비밀 번호가 정확하지 않습니다.");
        }
    }

    @Override
    public User findByToken(String token) {
        UserTokenDto userTokenDto = tokenService.verifyToken(token, true);
        return userRepository.findByUserId(userTokenDto.getUserId()).orElseThrow(() -> new IllegalStateException("유저를 찾을 수 없습니다."));
    }

    @Override
    public UserTokenDto verifyToken(String token) {
        return tokenService.verifyToken(token, true);
    }
}
