package dcom.homepage.api.domain.group.repository;

import dcom.homepage.api.domain.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    Optional<Group> getGroupByName(String name);
}
