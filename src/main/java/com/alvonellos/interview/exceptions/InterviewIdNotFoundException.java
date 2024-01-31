package com.alvonellos.interview.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = true)
public class InterviewIdNotFoundException extends InterviewAPIException {
    private final Long id;

    private final UUID uuid;

    public InterviewIdNotFoundException(final Long id) {
        super("Interview with id " + id + " not found");
        this.id = id;
        this.uuid = null;
    }

    public InterviewIdNotFoundException(final UUID id) {
        super("Interview with id" + id + " not found");
        this.id = null;
        this.uuid = id;
    }
}
