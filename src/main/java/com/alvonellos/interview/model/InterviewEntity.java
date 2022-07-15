package com.alvonellos.interview.model;

import javax.persistence.*;

@Entity(name = "interview")
@Table(name = "interview")
public class InterviewEntity {
    public InterviewEntity() {
    }

    public InterviewEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "key", nullable = false)
    private String key;

    public String getKey() {
        return key;
    }


    public void setKey(String key) {
        this.key = key;
    }

    @Column(name = "value", nullable = false)
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "InterviewEntity{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
