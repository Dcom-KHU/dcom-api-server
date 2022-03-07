package dcom.homepage.api.domain.users.service;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserLoginDto;
import dcom.homepage.api.domain.users.dto.UserProfileDto;
import dcom.homepage.api.domain.users.repository.UserRepository;
import dcom.homepage.api.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserProfileDto getProfileByUserId(String userId) throws NotFoundException {
        Optional<User> userById = userRepository.findByUserId(userId);

        if (userById.isPresent()) {
            User user = userById.get();
            UserProfileDto userProfileDto = UserProfileDto.of(user);
            return userProfileDto;
        } else {
            throw new NotFoundException("유저를 찾지 못했습니다.");
        }
    }

    @Override
    public User login(UserLoginDto userLoginDto) {
        String userId = userLoginDto.getUserId();
        String password = userLoginDto.getPassword();

        Optional<User> userOptional = userRepository.findByUserId(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String current_password = user.getPassword();
            if (passwordEncoder.matches(password, current_password)) {
                return user;
            } else {
                throw new NotFoundException("아이디 혹은 비밀 번호가 정확하지 않습니다.");
            }
        } else {
            throw new NotFoundException("아이디 혹은 비밀 번호가 정확하지 않습니다.");
        }
    }
}
