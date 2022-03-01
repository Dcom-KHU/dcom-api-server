package dcom.homepage.api.domain.group.repository;

import dcom.homepage.api.domain.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {

}
