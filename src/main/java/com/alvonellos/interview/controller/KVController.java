package com.alvonellos.interview.controller;

import com.alvonellos.interview.exceptions.InterviewAPIException;
import com.alvonellos.interview.model.KVEntity;
import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.service.KVService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController  // Because of SpringBoot ResponseBody implementation. We are not returning a view.
@AllArgsConstructor(onConstructor = @__(@Autowired)) // This is a Lombok annotation. It will generate a constructor with all the fields as parameters.
@Log
public class KVController {

    @Autowired private final KVDatabase kvDatabase;

    @Autowired private final KVService kvService;

    /**
     * This is a GET request. It is used to retrieve data from the server, but not to modify it.
     * @param key The key to retrieve from the database.
     * @return the value associated with the key.
     */
    @RequestMapping(value = "/example/{id}", method = RequestMethod.GET) // Could use @GetMapping instead, but this is more explicit.
    public ResponseEntity<KVEntity> get(HttpServletRequest request, @PathVariable Long id) throws InterviewAPIException {
        log.entering(this.getClass().getName(), "get", id);
        val result = kvService.get(id);
        log.exiting(this.getClass().getName(), "get", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * This is a GET all request. It is used to retrieve all data from the server, but not to modify it.
     * @return all records in the database.
     */
    @RequestMapping(value = "/example", method = RequestMethod.GET) // Could use @GetMapping instead, but this is more explicit.
    public ResponseEntity<List<KVEntity>> getAll(HttpServletRequest request) throws InterviewAPIException {
        log.entering(this.getClass().getName(), "getAll");
        val result = kvService.findAll();
        log.exiting(this.getClass().getName(), "getAll", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * This is a POST request. It is used to create a whole new record for example, customer information, file upload, etc.
     * @param key The key to store in the database.
     * @param value The value to store in the database.
     * @return the value associated with the key.
     */
    @RequestMapping(value = "/example", method = RequestMethod.POST, produces = "application/json") // Could use @PostMapping instead, but this is more explicit.
    public ResponseEntity<Long> post(HttpServletRequest request, @PathVariable String key, @RequestBody String value) throws InterviewAPIException {
        log.entering(this.getClass().getName(), "get", key);
        val result = kvService.post(key, value);
        log.exiting(this.getClass().getName(), "get", result);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * This is a PUT request. It is used to update an existing record.
     * @param key The key to store in the database.
     * @param value The value to store in the database.
     * @return the value associated with the key.
     */


}
