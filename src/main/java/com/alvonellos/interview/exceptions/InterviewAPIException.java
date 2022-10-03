package com.alvonellos.interview.exceptions;


import lombok.Data;

public abstract class InterviewAPIException extends Exception {
    public InterviewAPIException(String message) {
        super(message);
    }

    public InterviewAPIException(String message, Exception cause) {
        super(message, cause);
    }
}
