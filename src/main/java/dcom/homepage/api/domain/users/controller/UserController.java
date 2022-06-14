package dcom.homepage.api.domain.users.controller;

import dcom.homepage.api.domain.users.dto.UserResponseDto;
import dcom.homepage.api.domain.users.service.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"User Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/user")
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "userId를 가지고 있는 유저 정보를 반환 합니다.")
    @ApiImplicitParam(name = "userId", value = "조회할 유저 Id", required = true, dataType = "String")
    @GetMapping("/profile/{userId}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "유저 조회 성공"),
            @ApiResponse(code = 404, message = "유저 조회 실패")
    })
    public ResponseEntity<UserResponseDto.Profile> getProfileByUserId(@PathVariable final String userId) {
        return ResponseEntity.ok(userService.getProfileByUserId(userId));
    }


    @ApiOperation(value = "현재 로그인 되어있는 유저의 비밀 번호를 변경 합니다.")
    @PostMapping(value = "/change_password", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "비밀번호 변경 성공"),
            @ApiResponse(code = 400, message = "비밀번호 불일치"),
            @ApiResponse(code = 401, message = "유저 ")
    })
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ResponseEntity<Void> changePassword(@RequestParam("current_password") final String currentPassword,
                                               @RequestParam("new_password") final String newPassword) {
        userService.changePassword(currentPassword, newPassword);
        return ResponseEntity.accepted().build();
    }
}
