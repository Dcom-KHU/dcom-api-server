package dcom.homepage.api.domain.users.controller;

import dcom.homepage.api.domain.users.dto.UserResponseDto;
import dcom.homepage.api.domain.users.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"User Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "userId를 가지고 있는 유저 정보를 반환 합니다.")
    @ApiImplicitParam(name = "userId", value = "조회할 유저 Id", required = true, dataType = "String")
    @GetMapping("/profile/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<UserResponseDto.Profile> getProfileByUserId(@PathVariable final String userId) {
        return ResponseEntity.ok(userService.getProfileByUserId(userId));
    }
}
