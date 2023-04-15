package com.alvonellos.interview.repository;

import com.alvonellos.interview.dto.PersonAddressDTO;
import com.alvonellos.interview.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query("SELECT new com.alvonellos.interview.dto.PersonAddressDTO(p.personId, a.addressId, p.firstName, p.lastName, a.city, a.state) " +
            "FROM Person p LEFT JOIN Address a ON p.personId = a.personId")
    List<PersonAddressDTO> findAllWithAddress();
}
