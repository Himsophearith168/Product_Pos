package com.example.posproduct.Service;

import com.example.posproduct.DTO.UserRequest;
import com.example.posproduct.DTO.UserResonse;
import com.example.posproduct.Mapper.UserMapper;
import com.example.posproduct.Model.User;
import com.example.posproduct.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResonse createUser(UserRequest request) {
        User user = userMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    public List<UserResonse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    public UserResonse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toResponse(user);
    }

    public UserResonse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
        userMapper.updateEntity(user, request);
        User updatedUser = userRepository.save(user);
        return userMapper.toResponse(updatedUser);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
