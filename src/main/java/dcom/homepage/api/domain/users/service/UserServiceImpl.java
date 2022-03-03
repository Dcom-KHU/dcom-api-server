package dcom.homepage.api.domain.users.service;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserLoginDto;
import dcom.homepage.api.domain.users.dto.UserProfileDto;
import dcom.homepage.api.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Optional<UserProfileDto> getProfileByUserId(String userId) {
        Optional<User> userById = userRepository.findByUserId(userId);

        if (userById.isPresent()) {
            User user = userById.get();
            UserProfileDto userProfileDto = UserProfileDto.builder()
                    .id(user.getId())
                    .userId(user.getUserId())
                    .admissionYear(user.getAdmissionYear())
                    .realName(user.getRealName())
                    .github(user.getGithub())
                    .homepage(user.getHomepage())
                    .build();
            return Optional.of(userProfileDto);
        } else {
            return Optional.empty();
        }
    }
}
