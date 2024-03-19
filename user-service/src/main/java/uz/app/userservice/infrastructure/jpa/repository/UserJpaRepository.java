package uz.app.userservice.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.app.userservice.domain.entities.User;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
