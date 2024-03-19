package uz.app.userservice.application.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.app.userservice.domain.models.request.UserRequest;
import uz.app.userservice.domain.models.response.UserResponse;
import uz.app.userservice.domain.usecases.UserUseCase;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserUseCase userUseCase;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userUseCase.createUser(userRequest));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(userUseCase.getUser(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Integer userId,
            @RequestBody UserRequest userRequest
    ) {
        return ResponseEntity.ok(userUseCase.updateUser(userId, userRequest));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> usersList() {
        return ResponseEntity.ok(userUseCase.usersList());
    }
}
