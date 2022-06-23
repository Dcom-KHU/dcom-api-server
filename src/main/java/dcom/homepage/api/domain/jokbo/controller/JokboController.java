package dcom.homepage.api.domain.jokbo.controller;

import dcom.homepage.api.domain.jokbo.dto.JokboContentRequestDto;
import dcom.homepage.api.domain.jokbo.dto.JokboRequestDto;
import dcom.homepage.api.domain.jokbo.dto.JokboResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface JokboController {
    ResponseEntity<Page<JokboResponseDto.Simple>> searchAll(JokboRequestDto.Search search);
    ResponseEntity<Integer> postJokbo(JokboRequestDto.Post post);
    ResponseEntity<JokboResponseDto.Info> putJokbo(JokboRequestDto.Post post, Integer id);
    ResponseEntity<Void> deleteJokbo(Integer id);
    ResponseEntity<JokboResponseDto.Info> getJokbo(Integer id);
    ResponseEntity<Integer> postJokboContent(JokboContentRequestDto data, Integer id);
}
