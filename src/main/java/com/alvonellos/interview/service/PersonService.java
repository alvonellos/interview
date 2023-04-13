package com.alvonellos.interview.service;

import com.alvonellos.interview.dto.PersonAddressDTO;
import com.alvonellos.interview.model.Person;
import com.alvonellos.interview.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonAddressDTO> getPersonAddressList() {
        return personRepository.findAllWithAddress();
    }

}

