package com.alvonellos.interview.controller;

import com.alvonellos.interview.dto.PersonAddressDTO;
import com.alvonellos.interview.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @GetMapping("person/address")
    public List<PersonAddressDTO> getPersonAddressList() {
        return personService.getPersonAddressList();
    }

}

