package com.alvonellos.interview.controller;

import com.alvonellos.interview.service.Web3jService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController  // Because of SpringBoot ResponseBody implementation. We are not returning a view.
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class Web3jController {
    @Autowired
    private final Web3jService Web3jService;

    @GetMapping("/blockNumber")
    public ResponseEntity<String> getBlockNumber() throws IOException {
        return ResponseEntity.ok(Web3jService.getBlockNumber());
    }

    @GetMapping("/gasPrice")
    public ResponseEntity<String> getGasPrice() throws IOException {
        return ResponseEntity.ok(Web3jService.getGasPrice());
    }

    @GetMapping("/balance")
    public ResponseEntity<String> getBalance() throws IOException {
        return ResponseEntity.ok(Web3jService.getBalance());
    }

}
