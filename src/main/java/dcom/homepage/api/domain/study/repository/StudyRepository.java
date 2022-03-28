package dcom.homepage.api.domain.study.repository;

import dcom.homepage.api.domain.study.Study;
import dcom.homepage.api.domain.study.dto.StudyResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudyRepository extends JpaRepository<Study, Integer> {
    Optional<Study> getStudyById(Integer id);
    Page<Study> findAll(Pageable pageable);
    Page<Study> findAllByNameContains(String name, Pageable pageable);
}
