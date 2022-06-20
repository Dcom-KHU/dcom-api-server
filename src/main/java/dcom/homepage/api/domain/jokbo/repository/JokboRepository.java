package dcom.homepage.api.domain.jokbo.repository;

import dcom.homepage.api.domain.jokbo.Jokbo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JokboRepository extends JpaRepository<Jokbo, Integer> {
    Optional<Jokbo> findById(Integer id);
}