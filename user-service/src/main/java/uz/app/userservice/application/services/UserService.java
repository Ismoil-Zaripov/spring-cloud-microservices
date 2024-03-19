package uz.app.userservice.application.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uz.app.userservice.domain.models.request.UserRequest;
import uz.app.userservice.domain.models.response.UserResponse;
import uz.app.userservice.domain.usecases.UserUseCase;

import java.util.List;

@Service
@Transactional
public class UserService implements UserUseCase {
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse getUser(Integer userId) {
        return null;
    }

    @Override
    public UserResponse updateUser(Integer userId, UserRequest userRequest) {
        return null;
    }

    @Override
    public List<UserResponse> usersList() {
        return null;
    }
}
