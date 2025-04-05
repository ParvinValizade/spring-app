package paputu.company.az.service;

import paputu.company.az.dto.request.CreateUserRequest;
import paputu.company.az.dto.response.UserResponse;


public interface UserService {


    UserResponse createUser(CreateUserRequest userRequest);
}
