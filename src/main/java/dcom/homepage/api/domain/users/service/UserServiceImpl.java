package dcom.homepage.api.domain.users.service;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserRequestDto;
import dcom.homepage.api.domain.users.dto.UserResponseDto;
import dcom.homepage.api.domain.users.repository.UserRepository;
import dcom.homepage.api.global.security.provider.TokenProvider;
import dcom.homepage.api.global.security.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Override
    @Transactional
    public UserResponseDto.Profile getProfileByUserId(String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "유저를 찾지 못했습니다.")
        );
        return UserResponseDto.Profile.of(user);
    }

    @Override
    @Transactional
    public UserResponseDto.Profile register(UserRequestDto.Register userDto) {
        User userEntity = User.builder()
                .userId(userDto.getUserId())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .realName(userDto.getRealName())
                .email(userDto.getEmail())
                .admissionYear(userDto.getAdmissionYear())
                .phone(userDto.getPhone())
                .homepage(userDto.getHomepage())
                .github(userDto.getGithub())
                .build();

        return UserResponseDto.Profile.of(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public String login(UserRequestDto.Login userDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDto.getUserId(), userDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);

        return jwt;
    }

    @Override
    public boolean equalsPassword(String password, String encryptedPassword) {
        return passwordEncoder.matches(password, encryptedPassword);
    }

    @Transactional(readOnly = true)
    public User getUserWithAuthorities(String userId) {
        return userRepository.findOneWithAuthoritiesByUserId(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "유저가 존재하지 않습니다.")
        );
    }

    @Transactional(readOnly = true)
    public User getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUserId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "유저가 존재하지 않습니다.")
        );
    }
}
