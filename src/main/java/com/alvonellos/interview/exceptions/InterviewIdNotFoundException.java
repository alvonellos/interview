package com.alvonellos.interview.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = true)
public class InterviewIdNotFoundException extends InterviewAPIException {
    private Long id;

    public InterviewIdNotFoundException(Long id) {
        super("Interview with id " + id + " not found");
        this.id = id;
    }
}
