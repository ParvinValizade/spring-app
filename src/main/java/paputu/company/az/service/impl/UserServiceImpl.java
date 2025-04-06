package paputu.company.az.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paputu.company.az.dto.request.CreateUserRequest;
import paputu.company.az.dto.response.UserResponse;
import paputu.company.az.mapper.UserMapper;
import paputu.company.az.mapper.UserRequestMapper;
import paputu.company.az.model.User;
import paputu.company.az.repository.UserRepository;
import paputu.company.az.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserRequestMapper userRequestMapper;

    @Override
    public UserResponse createUser(CreateUserRequest userRequest) {

        User savedUser = userRepository.save(userRequestMapper.toEntity(userRequest));

        return userMapper.toDto(savedUser);
    }

    @Override
    public UserResponse getUserByEmail(String email) {

        User user = userRepository.findByEmail(email).orElseThrow(()->
                 new RuntimeException("can't find user by this email: " + email));

        return userMapper.toDto(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    public void deleteUserByEmail(String email) {
        userRepository.findByEmail(email)
                .ifPresent(userRepository::delete);

    }
}
