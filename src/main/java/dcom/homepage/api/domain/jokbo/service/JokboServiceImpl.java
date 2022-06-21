package dcom.homepage.api.domain.jokbo.service;

import dcom.homepage.api.domain.jokbo.dto.JokboRequestDto;
import dcom.homepage.api.domain.jokbo.dto.JokboResponseDto;
import dcom.homepage.api.domain.jokbo.repository.JokboQueryRepository;
import dcom.homepage.api.domain.jokbo.repository.JokboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JokboServiceImpl implements JokboService {
    private final JokboRepository jokboRepository;
    private final JokboQueryRepository jokboQueryRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<JokboResponseDto.Simple> searchAll(JokboRequestDto.Search search) {
        return jokboQueryRepository.searchAll(search, PageRequest.of(search.getPage(), search.getPageSize()));
    }
}
