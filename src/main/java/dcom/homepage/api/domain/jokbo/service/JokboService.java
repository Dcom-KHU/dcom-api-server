package dcom.homepage.api.domain.jokbo.service;

import dcom.homepage.api.domain.jokbo.JokboContent;
import dcom.homepage.api.domain.jokbo.dto.JokboContentResponseDto;
import dcom.homepage.api.domain.jokbo.dto.JokboRequestDto;
import dcom.homepage.api.domain.jokbo.dto.JokboResponseDto;
import org.springframework.data.domain.Page;

public interface JokboService {
    Page<JokboResponseDto.Simple> searchAll(JokboRequestDto.Search search);
    Integer postJokbo(JokboRequestDto.Post post);
    JokboResponseDto.Info getJokbo(Integer id);
    JokboResponseDto.Info putJokbo(JokboRequestDto.Post post, Integer id);
    void deleteJokbo(Integer id);
}
