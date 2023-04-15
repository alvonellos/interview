package com.alvonellos.interview.model;

import com.alvonellos.interview.dto.response.MemeResponseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity(name = "MemeEntity")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Validated
@NoArgsConstructor
public class MemeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    public MemeEntity(MemeResponseDTO.MemeDTO dto){
        this.id = dto.getId();
        this.name = dto.getName();
    }
}
