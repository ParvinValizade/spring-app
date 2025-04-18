package paputu.company.az.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import paputu.company.az.config.ApplicationConfig;
import paputu.company.az.dto.request.CreateUserRequest;
import paputu.company.az.dto.request.UpdateUserRequest;
import paputu.company.az.dto.response.UserResponse;
import paputu.company.az.exception.AlreadyUserExistsException;
import paputu.company.az.exception.NotFoundException;
import paputu.company.az.mapper.UpdateUserMapper;
import paputu.company.az.mapper.UserMapper;
import paputu.company.az.mapper.UserRequestMapper;
import paputu.company.az.model.User;
import paputu.company.az.repository.UserRepository;
import paputu.company.az.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserRequestMapper userRequestMapper;
    private final UpdateUserMapper updateUserMapper;
    private final ApplicationConfig applicationConfig;


    @PostConstruct
    public void createTestUser() {
        log.info("COUNT ::: {}", applicationConfig.getCount());
    }

    @Override
    public UserResponse createUser(CreateUserRequest userRequest) {
        userRepository.findByEmail(userRequest.getEmail())
                .ifPresent(user->{
                    throw new AlreadyUserExistsException("User already exists with email " + userRequest.getEmail());});

        User savedUser = userRepository.save(userRequestMapper.toEntity(userRequest));

        return userMapper.toDto(savedUser);
    }

    @Override
    public UserResponse getUserByEmail(String email) {

        //TODO NotFoundException
        User user = userRepository.findByEmail(email)
                .orElseThrow( () -> new NotFoundException("User not found with email " + email));

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

    @Override
    @Transactional
    public UserResponse updateUser(Long userId, UpdateUserRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow( () ->
                    new NotFoundException("User not found with ID " + userId)
                );

        updateUserMapper.updateUserFromRequest(request, user);

        return userMapper.toDto(user);
    }
}
