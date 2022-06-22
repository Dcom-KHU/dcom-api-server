package dcom.homepage.api.domain.jokbo.controller;

import dcom.homepage.api.domain.jokbo.dto.JokboRequestDto;
import dcom.homepage.api.domain.jokbo.dto.JokboResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface JokboController {
    ResponseEntity<Page<JokboResponseDto.Simple>> searchAll(JokboRequestDto.Search search);
    ResponseEntity<Integer> postJokbo(JokboRequestDto.Post post);
}
