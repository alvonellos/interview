package com.alvonellos.interview.controller;

import com.alvonellos.interview.service.AlgorithmsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlgorithmController {
    final AlgorithmsService algorithmsService;


}
