package dcom.homepage.api.domain.studycommits.service;

import dcom.homepage.api.domain.study.Study;
import dcom.homepage.api.domain.study.repository.StudyRepository;
import dcom.homepage.api.domain.studycommits.StudyCommit;
import dcom.homepage.api.domain.studycommits.repository.StudyCommitRepository;
import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudyCommitServiceImpl implements StudyCommitService {
    private StudyRepository studyRepository;
    private StudyCommitRepository studyCommitRepository;
    private UserRepository userRepository;

    @Override
    public List<? extends StudyCommit> findAllByUser(User user) {
        return studyCommitRepository.findAllByUser(user);
    }

    @Override
    public List<? extends StudyCommit> findAllByStudy(Study study) {
        return studyCommitRepository.findAllByStudy(study);
    }

    @Override
    public List<? extends StudyCommit> findAllByUserAndStudy(User user, Study study) {
        return studyCommitRepository.findAllByUserAndStudy(user, study);
    }

    @Override
    public List<? extends StudyCommit> findAllByUserAndSummitDate(User user, Date summitDate) {
        return studyCommitRepository.findAllByUserAndSummitDate(user, summitDate);
    }
}
