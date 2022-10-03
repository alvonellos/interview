package com.alvonellos.interview.exceptions;

import lombok.Data;

@Data
public class InterviewIdNotFoundException extends InterviewAPIException {
    public InterviewIdNotFoundException(String message) {
        super(message);
    }
    public InterviewIdNotFoundException(String message, Exception cause) {
        super(message, cause);
    }
}
