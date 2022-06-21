package dcom.homepage.api.domain.jokbo.controller;

import dcom.homepage.api.domain.jokbo.dto.JokboRequestDto;
import dcom.homepage.api.domain.jokbo.dto.JokboResponseDto;
import dcom.homepage.api.domain.jokbo.service.JokboService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Jokbo Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/jokbo")
public class JokboControllerImpl implements JokboController {
    private final JokboService jokboService;

    @ApiOperation(value = "Jokbo에 대한 검색을 수행 합니다.")
    @GetMapping("/list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "족보 리스트 조회 성공"),
            @ApiResponse(code = 404, message = "족보 리스트 조회 실패")
    })
    public ResponseEntity<Page<JokboResponseDto.Simple>> searchAll(JokboRequestDto.Search search) {
        return ResponseEntity.ok(jokboService.searchAll(search));
    }
}
