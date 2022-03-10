package dcom.homepage.api.domain.users.controller;

import dcom.homepage.api.domain.users.dto.UserResponseDto;
import dcom.homepage.api.domain.users.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/profile/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<UserResponseDto.Profile> getProfileByUserId(@PathVariable final String userId) {
        return ResponseEntity.ok(userService.getProfileByUserId(userId));
    }
}
