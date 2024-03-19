package uz.app.userservice.domain.models.request;


import uz.app.userservice.domain.entities.User;

public record UserRequest(
        String name,
        String surname,
        String email,
        String password
) {
    public User mapToEntity() {
        return User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .build();
    }
}
