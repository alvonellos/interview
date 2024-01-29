package com.alvonellos.interview.stackoverflow.Answer77901934;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "staff")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    @Id
    @SequenceGenerator(
            name = "staff_sequence",
            sequenceName = "staff_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "staff_sequence"
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "job", nullable = false)
    private String job;
}