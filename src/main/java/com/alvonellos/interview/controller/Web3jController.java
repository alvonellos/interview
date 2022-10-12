package com.alvonellos.interview.controller;

import com.alvonellos.interview.service.Web3jService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.CipherException;

import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.math.BigInteger;

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
    public ResponseEntity<BigInteger> getGasPrice() throws IOException {
        return ResponseEntity.ok(Web3jService.getGasPrice());
    }

    @GetMapping("/balance/{address}")
    public ResponseEntity<String> getBalance(@NotBlank @PathVariable(name = "address") String address) throws IOException, CipherException {
        return ResponseEntity.ok(Web3jService.getBalance(address));
    }

    @GetMapping("/admin")
    public ResponseEntity<String> getAdmin() throws IOException {
        return ResponseEntity.ok(Web3jService.getAdmin());
    }

    @GetMapping("/transfer/{from}/{to}/{amount}")
    public ResponseEntity<String> transfer(@NotBlank @PathVariable(name = "from") String from,
                                           @NotBlank @PathVariable(name = "to") String to,
                                           @NotBlank @PathVariable(name = "amount") BigInteger amount) throws IOException, CipherException {
        return ResponseEntity.ok(Web3jService.ethTransfer(from, to, amount));
    }
}
