package dcom.homepage.api.domain.users.repository;

import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserProfileDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Integer id);
    Optional<User> findByUserId(String userId);
}
