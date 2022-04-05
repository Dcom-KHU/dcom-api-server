package dcom.homepage.api.domain.studycommits.service;

import dcom.homepage.api.domain.study.Study;
import dcom.homepage.api.domain.studycommits.StudyCommit;
import dcom.homepage.api.domain.users.User;

import java.util.Date;
import java.util.List;

public interface StudyCommitService {
    List<? extends StudyCommit> findAllByUser(User user);
    List<? extends StudyCommit> findAllByStudy(Study study);
    List<? extends StudyCommit> findAllByUserAndStudy(User user, Study study);
    List<? extends StudyCommit> findAllByUserAndSummitDate(User user, Date summitDate);
}
