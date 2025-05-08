package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for User entity using Spring Data JPA.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by email.
     * 
     * @param email the email to search for
     * @return the user with the given email or null if not found
     */
    User findByEmail(String email);

    /**
     * Check if a user with the given id exists.
     * 
     * @param id the id to check
     * @return true if a user with the given id exists, false otherwise
     */
    boolean existsById(Long id);
}
