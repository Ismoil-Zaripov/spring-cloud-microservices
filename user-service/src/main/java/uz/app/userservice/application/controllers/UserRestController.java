package uz.app.userservice.application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.app.userservice.domain.models.request.UserRequest;
import uz.app.userservice.domain.models.response.UserResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return null;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Integer userId) {
        return null;
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Integer userId,
            @RequestBody UserRequest userRequest
    ) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> usersList() {
        return null;
    }
}
