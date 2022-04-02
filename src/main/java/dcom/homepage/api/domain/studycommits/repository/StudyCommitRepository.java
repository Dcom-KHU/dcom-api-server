package dcom.homepage.api.domain.studycommits.repository;

import dcom.homepage.api.domain.studycommits.StudyCommit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyCommitRepository<T extends StudyCommit> extends JpaRepository<T, Long> {
}
