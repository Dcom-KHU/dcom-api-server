package dcom.homepage.api.domain.users.controller;

import dcom.homepage.api.domain.users.dto.UserLoginDto;
import dcom.homepage.api.domain.users.dto.UserProfileDto;
import dcom.homepage.api.domain.users.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    @GetMapping("/profile/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody()
    public UserProfileDto getProfileByUserId(@PathVariable final String userId) {
        return userService.getProfileByUserId(userId).get();
    }
}
