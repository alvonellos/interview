package com.alvonellos.interview.dto;

import com.alvonellos.interview.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonAddressDTO {

    private Long personId;

    private Long addressId;

    private String firstName;

    private String lastName;

    private String city;

    private String state;

    public PersonAddressDTO(Long personId, String firstName, String lastName) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static PersonAddressDTO fromPerson(Person person) {
        return new PersonAddressDTO(person.getPersonId(), person.getFirstName(), person.getLastName());
    }

    public static List<PersonAddressDTO> fromPersonList(List<Person> personList) {
        return personList.stream().map(PersonAddressDTO::fromPerson).toList();
    }
}
