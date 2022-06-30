package dcom.homepage.api.domain.jokbo.service;

import dcom.homepage.api.domain.jokbo.Jokbo;
import dcom.homepage.api.domain.jokbo.JokboContent;
import dcom.homepage.api.domain.jokbo.dto.JokboContentRequestDto;
import dcom.homepage.api.domain.jokbo.dto.JokboContentResponseDto;
import dcom.homepage.api.domain.jokbo.dto.JokboRequestDto;
import dcom.homepage.api.domain.jokbo.dto.JokboResponseDto;
import dcom.homepage.api.domain.jokbo.repository.JokboContentRepository;
import dcom.homepage.api.domain.jokbo.repository.JokboQueryRepository;
import dcom.homepage.api.domain.jokbo.repository.JokboRepository;
import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class JokboServiceImpl implements JokboService {
    private final JokboRepository jokboRepository;
    private final JokboQueryRepository jokboQueryRepository;
    private final JokboContentRepository jokboContentRepository;
    private final UserService userService;

    @Override
    @Transactional(readOnly = true)
    public Page<JokboResponseDto.Simple> searchAll(JokboRequestDto.Search search) {
        return jokboQueryRepository.searchAll(search, PageRequest.of(search.getPage(), search.getPageSize()));
    }

    @Override
    @Transactional
    public Integer postJokbo(JokboRequestDto.Post post) {
        User user = userService.getMyUserWithAuthorities();

        Jokbo jokbo = Jokbo.builder()
                .writer(user)
                .professor(post.getProfessor())
                .course(post.getCourse())
                .build();

        try {
            return jokboRepository.save(jokbo).getId();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "에러가 발생 했습니다, 중복된 강의-교수 족보가 존재 하는지 확인 해 주세요.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public JokboResponseDto.Info getJokbo(Integer id) {
        return JokboResponseDto.Info.of(jokboRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "족보를 찾을 수 없습니다."
        )));
    }

    @Override
    @Transactional
    public JokboResponseDto.Info putJokbo(JokboRequestDto.Post post, Integer id) {
        User user = userService.getMyUserWithAuthorities();

        Jokbo jokbo = jokboRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "족보를 찾을 수 없습니다."
        ));

        if (jokbo.getWriter() != user) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "본인의 족보만 수정 할 수 있습니다."
            );
        }

        jokbo.setProfessor(post.getProfessor());
        jokbo.setCourse(post.getCourse());

        return JokboResponseDto.Info.of(jokboRepository.save(jokbo));
    }

    @Override
    @Transactional
    public void deleteJokbo(Integer id) {
        User user = userService.getMyUserWithAuthorities();

        Jokbo jokbo = jokboRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "족보를 찾을 수 없습니다."
        ));

        if (jokbo.getWriter() != user) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "본인의 족보만 삭제 할 수 있습니다."
            );
        }

        jokboRepository.delete(jokbo);
    }

    @Override
    @Transactional
    public Integer postJokboContent(JokboContentRequestDto data, Integer id) {
        User user = userService.getMyUserWithAuthorities();

        Jokbo jokbo = jokboRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "족보를 찾을 수 없습니다."
        ));

        JokboContent jokboContent = JokboContent.builder()
                .writer(user)
                .jokbo(jokbo)
                .content(data.getContent())
                .semester(data.getSemester())
                .build();

        return jokboContentRepository.save(jokboContent).getId();
    }

    @Override
    public JokboContentResponseDto putJokboContent(JokboContentRequestDto data, Integer id) {
        return null;
    }

    @Override
    public void deleteJokboContent(Integer id) {
        User user = userService.getMyUserWithAuthorities();

        JokboContent jokboContent = jokboContentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "해당 족보 글을 찾을 수 없습니다."
        ));

        if (jokboContent.getWriter() != user) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "본인의 족보 글만 삭제 할 수 있습니다."
            );
        }

        jokboContentRepository.delete(jokboContent);
    }
}
