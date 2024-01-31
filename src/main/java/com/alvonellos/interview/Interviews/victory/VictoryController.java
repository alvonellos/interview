package com.alvonellos.interview.Interviews.victory;


import com.alvonellos.interview.exceptions.InterviewIdNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/victory")
public class VictoryController {
    private final VictoryService victoryService;

    @GetMapping("/status")
    public ResponseEntity<Boolean> health() {
        return ResponseEntity.ok(victoryService.health());
    }

    @GetMapping
    public ResponseEntity<Victory> get(UUID id) throws InterviewIdNotFoundException {
        return ResponseEntity.ok(victoryService.get(id));
    }

    @PostMapping
    public ResponseEntity<URI> post(@RequestParam(name = "value") String value) throws InterviewIdNotFoundException {
        return new ResponseEntity<>(victoryService.post(value), HttpStatus.CREATED);
    }
}
