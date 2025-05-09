package com.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

/**
 * Specification for testing the Application class.
 * This test suite verifies that the Spring application context loads successfully.
 */
@SpringBootTest
class ApplicationSpec extends Specification {

    @Autowired
    ApplicationContext context

    /**
     * Test that verifies the application context loads successfully.
     * This ensures that the Spring Boot application can start without errors.
     */
    def "should load application context"() {
        expect: "the application context to be loaded"
        context != null
    }

    /**
     * Test that verifies the main method can be called without errors.
     * This is a simple smoke test for the main method.
     */
    def "should run main method without errors"() {
        when: "the main method is called"
        Application.main(new String[0])

        then: "no exception is thrown"
        noExceptionThrown()
    }
}