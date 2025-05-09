package com.example.repository

import com.example.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Specification for testing the UserRepository interface.
 * This test suite verifies that the UserRepository correctly performs
 * database operations for the User entity using Spring Data JPA.
 */
@DataJpaTest
class UserRepositorySpec extends Specification {

    @Autowired
    UserRepository userRepository

    def cleanup() {
        // Clean up after each test
        userRepository.deleteAll()
    }

    /**
     * Test that verifies the findByEmail method correctly finds a user when it exists.
     * It ensures that the repository returns the correct user with all properties intact.
     */
    def "should find user by email when user exists"() {
        given: "a user saved in the repository"
        def user = new User("John Doe", "john@example.com", "123456789")
        userRepository.save(user)

        when: "findByEmail is called with an existing email"
        def result = userRepository.findByEmail("john@example.com")

        then: "the result should be the correct user with all properties intact"
        result != null
        result.name == "John Doe"
        result.email == "john@example.com"
        result.phone == "123456789"
    }

    /**
     * Test that verifies the findByEmail method correctly handles the case when a user doesn't exist.
     * It ensures that the repository returns null for a non-existent email.
     */
    def "should return null when finding by email that does not exist"() {
        when: "findByEmail is called with a non-existent email"
        def result = userRepository.findByEmail("nonexistent@example.com")

        then: "the result should be null"
        result == null
    }

    /**
     * Test that verifies the existsById method correctly identifies when a user exists.
     * It ensures that the repository returns true for an existing user ID.
     */
    def "should return true when checking if user exists by id"() {
        given: "a user saved in the repository"
        def user = new User()
        user.name = "Jane Doe"
        user.email = "jane@example.com"
        user.phone = "987654321"

        userRepository.save(user)

        when: "existsById is called with the user's ID"
        def exists = userRepository.existsById(user.id)

        then: "the result should be true"
        exists
    }

    /**
     * Test that verifies the existsById method correctly identifies when a user doesn't exist.
     * It ensures that the repository returns false for a non-existent user ID.
     */
    def "should return false when checking if user exists by id that does not exist"() {
        when: "existsById is called with a non-existent ID"
        def exists = userRepository.existsById(999L)

        then: "the result should be false"
        !exists
    }
}
