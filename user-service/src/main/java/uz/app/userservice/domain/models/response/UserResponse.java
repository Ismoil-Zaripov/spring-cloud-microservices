package uz.app.userservice.domain.models.response;

import lombok.Builder;
import uz.app.userservice.domain.constants.UserRole;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
public record UserResponse(
        Integer id,
        String name,
        String surname,
        String email,
        UserRole role,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) implements Serializable { }