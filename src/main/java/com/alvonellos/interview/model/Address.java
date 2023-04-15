package com.alvonellos.interview.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personId;

    private String city;

    private String state;

}
