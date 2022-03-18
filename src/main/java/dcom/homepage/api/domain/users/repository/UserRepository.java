package dcom.homepage.api.domain.users.repository;

import dcom.homepage.api.domain.users.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @EntityGraph(attributePaths = {"authorities"})
    Optional<User> findOneWithAuthoritiesByUserId(String userId);

    Optional<User> findById(Integer id);
    Optional<User> findByUserId(String userId);
}
