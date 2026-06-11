package com.example.posproduct.Mapper;

import com.example.posproduct.DTO.UserRequest;
import com.example.posproduct.DTO.UserResonse;
import com.example.posproduct.Model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequest request) {
        if (request == null) return null;
        return User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public UserResonse toResponse(User user) {
        if (user == null) return null;
        return UserResonse.builder()
                .user_id(user.getUser_id())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    public void updateEntity(User user, UserRequest request) {
        if (user == null || request == null) return;
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
    }
}
