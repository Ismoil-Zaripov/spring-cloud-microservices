package uz.app.userservice.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import uz.app.userservice.domain.constants.UserRole;
import uz.app.userservice.domain.models.response.UserResponse;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    public UserResponse mapToResponse(){
        return UserResponse.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .email(email)
                .role(role)
                .createdDate(createdDate)
                .updatedDate(updatedDate)
                .build();
    }


}
