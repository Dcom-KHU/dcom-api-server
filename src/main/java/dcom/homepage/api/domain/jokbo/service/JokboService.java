package dcom.homepage.api.domain.jokbo.service;

import dcom.homepage.api.domain.jokbo.dto.JokboRequestDto;
import dcom.homepage.api.domain.jokbo.dto.JokboResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JokboService {
    Page<JokboResponseDto.Simple> searchAll(JokboRequestDto.Search search);
}
