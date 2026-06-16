package com.example.posproduct.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "UserName is Require")
    private String username;
    @NotNull(message = "Email is not nul")
    private String email;
    @NotNull(message = "The Password is not null")
    private String password;
}
