package com.alvonellos.interview.Interviews.victory;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VictoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column(name = "value")
    @Builder.Default
    private String value = "";

    public Victory toDto() {
        return new Victory(id, value);
    }
}
