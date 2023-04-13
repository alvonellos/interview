package com.alvonellos.interview.controller;

import com.alvonellos.interview.dto.PersonAddressDTO;
import com.alvonellos.interview.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/address")
    public List<PersonAddressDTO> getPersonAddressList() {
        return personService.getPersonAddressList();
    }

}

