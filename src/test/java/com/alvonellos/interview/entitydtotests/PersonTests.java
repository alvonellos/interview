package com.alvonellos.interview.entitydtotests;

import com.alvonellos.interview.dto.PersonAddressDTO;
import com.alvonellos.interview.helpers.PersonTestHelper;
import com.alvonellos.interview.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTests {

    @Test
    public void testPersonEntity() {
        int personId = 1;
        String firstName = "Alice";
        String lastName = "Bob";
        Person person = new Person((long) personId, firstName, lastName);
        assertEquals(personId, person.getPersonId());
        assertEquals(firstName, person.getFirstName());
        assertEquals(lastName, person.getLastName());
    }

    @Test
    public void testPersonAddressDTO() {
        Long personId = 1l;
        String firstName = "Alice";
        String lastName = "Bob";
        PersonAddressDTO personDTO = new PersonAddressDTO(personId, firstName, lastName);
        assertEquals(personId, personDTO.getPersonId());
        assertEquals(firstName, personDTO.getFirstName());
        assertEquals(lastName, personDTO.getLastName());
    }

    @Test
    public void testPersonDTOFromEntity() {
        Long personId = 1l;
        String firstName = "Alice";
        String lastName = "Bob";
        Person person = new Person(personId, firstName, lastName);
        PersonAddressDTO personDTO = PersonAddressDTO.fromPerson(person);
        assertEquals(personId, personDTO.getPersonId());
        assertEquals(firstName, personDTO.getFirstName());
        assertEquals(lastName, personDTO.getLastName());
    }

    @Test
    public void testPersonListDTOFromEntityList() {
        int size = 10;
        List<Person> personList = PersonTestHelper.generatePersonList(size);
        List<PersonAddressDTO> personDTOList = PersonAddressDTO.fromPersonList(personList);
        assertEquals(size, personDTOList.size());
        for (int i = 0; i < size; i++) {
            Person person = personList.get(i);
            PersonAddressDTO personDTO = personDTOList.get(i);
            assertEquals(person.getPersonId(), personDTO.getPersonId());
            assertEquals(person.getFirstName(), personDTO.getFirstName());
            assertEquals(person.getLastName(), personDTO.getLastName());
        }
    }
}

