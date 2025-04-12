package paputu.company.az.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import paputu.company.az.dto.request.CreateUserRequest;
import paputu.company.az.dto.request.UpdateUserRequest;
import paputu.company.az.dto.response.UserResponse;
import paputu.company.az.service.UserService;

import java.util.List;

@RestController
@RequestMapping("v1/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long userId,
                                                   @RequestBody UpdateUserRequest request) {
        return new ResponseEntity<>(userService.updateUser(userId, request), HttpStatus.ACCEPTED);
    }


    @GetMapping("/by")
    public ResponseEntity<UserResponse> getUserByEmail(@RequestParam String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/delete-by")
    public ResponseEntity<Void> deleteUserByEmail(@RequestParam String email){
        userService.deleteUserByEmail(email);
        return ResponseEntity.ok().build();
    }
}
