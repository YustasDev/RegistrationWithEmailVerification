package com.example.registrationwithemailverification.repository;

import com.example.registrationwithemailverification.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmailIgnoreCase(String emailId);
    Optional<User> findUserByUserName(String username);

    Boolean existsByUserEmail(String email);

}
