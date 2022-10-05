package com.alvonellos.interview.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "KVEntity")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Validated
@NoArgsConstructor
public class KVEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kv_entity_id", nullable = false, unique = true)
    @JsonProperty("kv_entity_id")
    private Long KVEntityId;

    @Column(name = "kv_entity_key", nullable = false)
    @JsonProperty("kv_entity_key")
    @NotBlank
    private String KVEntityKey;


    @Column(name = "kv_entity_value", length = 10000) // NULLABLE
    @JsonProperty("kv_entity_value")
    @Nullable
    private String KVEntityValue;

    public KVEntity(String key, String value) {
        this.KVEntityKey = key;
        this.KVEntityValue = value;
    }

    @Override
    public String toString() {
        return "KVEntity{" +
                "id=" + this.KVEntityId +
                ", key='" + KVEntityKey + '\'' +
                ", value='" + KVEntityValue + '\'' +
                '}';
    }
}
