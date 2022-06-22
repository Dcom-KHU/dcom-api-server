package dcom.homepage.api.domain.jokbo.repository;

import dcom.homepage.api.domain.jokbo.Jokbo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JokboRepository extends JpaRepository<Jokbo, Integer> {
    @EntityGraph(attributePaths = {"writer", "contents"})
    Optional<Jokbo> findById(Integer id);
}