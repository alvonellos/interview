package com.alvonellos.interview.exceptions;

public class InterviewIllegalArgumentException extends InterviewAPIException {
    public InterviewIllegalArgumentException(String message) {
        super(message);
    }

    public InterviewIllegalArgumentException(String message, Exception cause) {
        super(message, cause);
    }
}
