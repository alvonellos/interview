package com.alvonellos.interview.exceptions;

public class InterviewAPIError {
    public String message;
    public String logRef;

public Exception cause;

    public InterviewAPIError(String message, String logRef) {
        super(message);
        this.message = message;
        this.logRef = logRef;
    }

    public String getMessage() {
        return message;
    }

    public String getLogRef() {
        return logRef;
    }
}
