package com.alvonellos.interview.exceptions;


public abstract class InterviewAPIException extends Exception {
    protected InterviewAPIException(String message) {
        super(message);
    }

    protected InterviewAPIException(String message, Exception cause) {
        super(message, cause);
    }
}
