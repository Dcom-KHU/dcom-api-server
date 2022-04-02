package dcom.homepage.api.domain.studycommits.repository;

import dcom.homepage.api.domain.study.Study;
import dcom.homepage.api.domain.studycommits.StudyCommit;
import dcom.homepage.api.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface StudyCommitRepository<T extends StudyCommit> extends JpaRepository<T, Long> {
    List<T> findAllByUser(User user);
    List<T> findAllByStudy(Study study);
    List<T> findAllByUserAndStudy(User user, Study study);
    List<T> findAllByUserAndSummitDate(User user, Date summitDate);
}
