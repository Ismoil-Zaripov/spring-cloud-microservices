package uz.app.userservice.domain.usecases;

import uz.app.userservice.domain.models.request.UserRequest;
import uz.app.userservice.domain.models.response.UserResponse;

import java.util.List;

public interface UserUseCase {
    UserResponse createUser(UserRequest userRequest);
    UserResponse getUser(Integer userId);
    UserResponse updateUser(Integer userId, UserRequest userRequest);
    List<UserResponse> usersList();
}