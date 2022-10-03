package com.alvonellos.interview.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "KVEntity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KVEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kv_entity_id", nullable = false)
    private Long KVEntityId;

    @Column(name = "kv_entity_key", nullable = false)
    private String KVEntityKey;


    @Column(name = "kv_entity_value", length = 10000) // NULLABLE
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
