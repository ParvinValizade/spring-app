package paputu.company.az.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paputu.company.az.dto.request.CreateUserRequest;
import paputu.company.az.dto.response.UserResponse;
import paputu.company.az.model.User;
import paputu.company.az.repository.UserRepository;
import paputu.company.az.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(CreateUserRequest userRequest) {
        User user = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();


        User savedUser = userRepository.save(user);

        return UserResponse.builder()
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .email(savedUser.getEmail())
                .build();
    }
}
