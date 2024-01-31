package com.alvonellos.interview.Interviews.victory;

import java.util.UUID;

public record Victory(UUID id, String value) {

    public VictoryEntity toEntity() {
        return VictoryEntity.builder()
                .id(this.id())
                .value(this.value())
                .build();
    }
}
