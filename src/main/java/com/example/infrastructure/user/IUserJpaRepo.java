package com.example.infrastructure.user;

import com.example.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IUserJpaRepo extends JpaRepository<User, UUID> {
    Optional<User> findUserByUsername(String email);
}
