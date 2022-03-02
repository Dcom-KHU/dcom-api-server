package dcom.homepage.api.domain.users.service;

import dcom.homepage.api.domain.users.dto.UserProfileDto;
import dcom.homepage.api.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<UserProfileDto> getProfileByUserId(String userId);
}
