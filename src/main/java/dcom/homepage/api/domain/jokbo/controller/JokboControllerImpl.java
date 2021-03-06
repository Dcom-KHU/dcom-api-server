package dcom.homepage.api.domain.jokbo.controller;

import dcom.homepage.api.domain.jokbo.dto.JokboContentRequestDto;
import dcom.homepage.api.domain.jokbo.dto.JokboRequestDto;
import dcom.homepage.api.domain.jokbo.dto.JokboResponseDto;
import dcom.homepage.api.domain.jokbo.service.JokboService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"Jokbo Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/jokbo")
public class JokboControllerImpl implements JokboController {
    private final JokboService jokboService;

    @ApiOperation(value = "Jokbo에 대한 조회를 수행 합니다.")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 400, message = "요청 실패"),
            @ApiResponse(code = 404, message = "족보 조회 실패")
    })
    public ResponseEntity<JokboResponseDto.Info> getJokbo(@PathVariable Integer id) {
        return ResponseEntity.accepted().body(jokboService.getJokbo(id));
    }

    @ApiOperation(value = "Jokbo에 대한 등록을 수행 합니다.")
    @PostMapping("")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "족보 등록 성공, 족보 ID 반환"),
            @ApiResponse(code = 400, message = "족보 등록 실패")
    })
    public ResponseEntity<Integer> postJokbo(@Valid JokboRequestDto.Post post) {
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
            @ApiResponse(code = 400, message = "족보 변경 실패"),
            @ApiResponse(code = 401, message = "로그인 필요"),
            @ApiResponse(code = 403, message = "본인의 족보만 수정 가능"),
            @ApiResponse(code = 404, message = "족보 조회 실패")
    })
    public ResponseEntity<JokboResponseDto.Info> putJokbo(@Valid JokboRequestDto.Post post, @PathVariable Integer id) {
        return ResponseEntity.accepted().body(jokboService.putJokbo(post, id));
    }

    @ApiOperation(value = "Jokbo에 대한 삭제를 수행 합니다.")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "족보 삭제 성공"),
            @ApiResponse(code = 400, message = "족보 삭제 실패"),
            @ApiResponse(code = 401, message = "로그인 필요"),
            @ApiResponse(code = 403, message = "본인의 족보만 수정 가능"),
            @ApiResponse(code = 404, message = "족보 조회 실패")
    })
    public ResponseEntity<Void> deleteJokbo(@PathVariable Integer id) {
        jokboService.deleteJokbo(id);
        return ResponseEntity.accepted().build();
    }

    @ApiOperation(value = "Jokbo Content에 대한 등록을 수행 합니다.")
    @ApiImplicitParam(name = "id", value = "족보 ID", required = true, dataType = "String")
    @PostMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "족보 등록 성공, 족보 ID 반환"),
            @ApiResponse(code = 400, message = "족보 등록 실패")
    })
    public ResponseEntity<Integer> postJokboContent(JokboContentRequestDto data, @PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jokboService.postJokboContent(data, id));
    }
}
