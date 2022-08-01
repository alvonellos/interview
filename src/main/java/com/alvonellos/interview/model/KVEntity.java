package com.alvonellos.interview.model;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.Valid;

@Entity(name = "KVEntity")
@Builder
@Valid
public class KVEntity {
    public KVEntity() {
    }

    public KVEntity(String key, String value) {
        this.KVEntityKey = key;
        this.KVEntityValue = value;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kv_entity_id", nullable = false)
    private Long KVEntityId;

    @Column(name = "kv_entity_key", nullable = false)
    private String KVEntityKey;


    @Column(name = "kv_entity_value") // NULLABLE
    private String KVEntityValue;

    @Override
    public String toString() {
        return "KVEntity{" +
                "id=" + this.KVEntityId +
                ", key='" + KVEntityKey + '\'' +
                ", value='" + KVEntityValue + '\'' +
                '}';
    }
}
