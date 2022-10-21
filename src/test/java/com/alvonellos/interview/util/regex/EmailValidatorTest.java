package com.alvonellos.interview.util.regex;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @org.junit.jupiter.api.Test
    void isValid() {
        assertTrue(EmailValidator.isValid("test@test.com"));
    }

}