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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Jokbo Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/jokbo")
public class JokboControllerImpl implements JokboController {
    private final JokboService jokboService;

    @ApiOperation(value = "Jokbo에 대한 등록을 수행 합니다.")
    @PostMapping("")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "족보 등록 성공, 족보 ID 반환"),
            @ApiResponse(code = 400, message = "족보 등록 실패")
    })
    public ResponseEntity<Integer> postJokbo(JokboRequestDto.Post post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jokboService.postJokbo(post));
    }

    @ApiOperation(value = "Jokbo에 대한 검색을 수행 합니다.")
    @GetMapping("/list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "족보 리스트 조회 성공"),
            @ApiResponse(code = 404, message = "족보 리스트 조회 실패")
    })
    public ResponseEntity<Page<JokboResponseDto.Simple>> searchAll(JokboRequestDto.Search search) {
        return ResponseEntity.ok(jokboService.searchAll(search));
    }

    @ApiOperation(value = "Jokbo에 대한 변경을 수행 합니다.")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "족보 변경 성공, 족보 정보 반환"),
            @ApiResponse(code = 400, message = "족보 변경 실패")
    })
    public ResponseEntity<JokboResponseDto.Info> putJokbo(JokboRequestDto.Post post, @PathVariable Integer id) {
        return ResponseEntity.accepted().body(jokboService.putJokbo(post, id));
    }
}
