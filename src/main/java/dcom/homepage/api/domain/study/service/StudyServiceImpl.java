package dcom.homepage.api.domain.study.service;

import dcom.homepage.api.domain.study.Study;
import dcom.homepage.api.domain.study.dto.StudyRequestDto;
import dcom.homepage.api.domain.study.dto.StudyResponseDto;
import dcom.homepage.api.domain.study.repository.StudyRepository;
import dcom.homepage.api.domain.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {
    private final StudyRepository studyRepository;

    @Override
    public StudyResponseDto.Info findStudyById(Integer id) {
        return StudyResponseDto.Info.of(studyRepository.getStudyById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "스터디를 찾을 수 없습니다.")
        ));
    }

    @Override
    public StudyResponseDto.SimpleInfo makeStudy(User user, StudyRequestDto.Make make) {
        Study study = Study.builder()
                .name(make.getName())
                .type(make.getType())
                .description(make.getDescription())
                .startDate(make.getStartDate())
                .endDate(make.getEndDate())
                .cycle(make.getCycle())
                .build();
        studyRepository.save(study);

        return StudyResponseDto.SimpleInfo.of(study);
    }

    @Override
    public Page<StudyResponseDto.SimpleInfo> findAll(Pageable pageable) {
        return studyRepository.findAll(pageable).map(StudyResponseDto.SimpleInfo::of);
    }

    @Override
    public Page<StudyResponseDto.SimpleInfo> findAllByNameContains(String name, Pageable pageable) {
        return studyRepository.findAllByNameContains(name, pageable).map(StudyResponseDto.SimpleInfo::of);
    }
}
