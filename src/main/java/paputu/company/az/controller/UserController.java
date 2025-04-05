package paputu.company.az.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import paputu.company.az.dto.request.CreateUserRequest;
import paputu.company.az.dto.response.UserResponse;
import paputu.company.az.service.UserService;

@RestController
@RequestMapping("v1/api/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;



    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest userRequest) {
            return ResponseEntity.ok(userService.createUser(userRequest));
    }
}
