package dcom.homepage.api.domain.users.service;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserRequestDto;
import dcom.homepage.api.domain.users.dto.UserResponseDto;
import dcom.homepage.api.domain.users.repository.UserRepository;
import dcom.homepage.api.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponseDto.Profile getProfileByUserId(String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new NotFoundException("유저를 찾지 못했습니다."));
        return UserResponseDto.Profile.of(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean equalsPassword(String password, String encryptedPassword) {
        return passwordEncoder.matches(password, encryptedPassword);
    }
}
