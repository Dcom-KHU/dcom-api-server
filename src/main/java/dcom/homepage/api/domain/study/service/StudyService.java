package dcom.homepage.api.domain.study.service;

import dcom.homepage.api.domain.study.Study;
import dcom.homepage.api.domain.study.dto.StudyRequestDto;
import dcom.homepage.api.domain.study.dto.StudyResponseDto;
import dcom.homepage.api.domain.users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudyService {
    StudyResponseDto.Info findStudyById(Integer id);
    StudyResponseDto.SimpleInfo makeStudy(User user, StudyRequestDto.Make make);
    Page<StudyResponseDto.SimpleInfo> findAll(Pageable pageable);
    Page<StudyResponseDto.SimpleInfo> findAllByNameContains(String name, Pageable pageable);
}
