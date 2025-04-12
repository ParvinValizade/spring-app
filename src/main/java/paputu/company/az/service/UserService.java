package paputu.company.az.service;

import paputu.company.az.dto.request.CreateUserRequest;
import paputu.company.az.dto.request.UpdateUserRequest;
import paputu.company.az.dto.response.UserResponse;

import java.util.List;


public interface UserService {


    UserResponse createUser(CreateUserRequest userRequest);

    UserResponse getUserByEmail(String email);

    List<UserResponse> getAllUsers();

    void deleteUserByEmail(String email);

    UserResponse updateUser(Long userId, UpdateUserRequest request);
}
