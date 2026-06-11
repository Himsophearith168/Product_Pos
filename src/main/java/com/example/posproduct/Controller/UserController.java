package com.example.posproduct.Controller;

import com.example.posproduct.DTO.UserRequest;
import com.example.posproduct.DTO.UserResonse;
import com.example.posproduct.Service.UserService;
import com.example.posproduct.Util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<APIResponse<UserResonse>> createUser(@RequestBody UserRequest request) {
        UserResonse response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                APIResponse.<UserResonse>builder()
                        .status(HttpStatus.CREATED.value())
                        .message("User created successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<UserResonse>>> getAllUsers() {
        List<UserResonse> responses = userService.getAllUsers();
        return ResponseEntity.ok(
                APIResponse.<List<UserResonse>>builder()
                        .status(HttpStatus.OK.value())
                        .message("Users retrieved successfully")
                        .data(responses)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<UserResonse>> getUserById(@PathVariable Long id) {
        UserResonse response = userService.getUserById(id);
        return ResponseEntity.ok(
                APIResponse.<UserResonse>builder()
                        .status(HttpStatus.OK.value())
                        .message("User retrieved successfully")
                        .data(response)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<UserResonse>> updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
        UserResonse response = userService.updateUser(id, request);
        return ResponseEntity.ok(
                APIResponse.<UserResonse>builder()
                        .status(HttpStatus.OK.value())
                        .message("User updated successfully")
                        .data(response)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(
                APIResponse.<Void>builder()
                        .status(HttpStatus.OK.value())
                        .message("User deleted successfully")
                        .build()
        );
    }
}
