package com.alvonellos.interview.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;

import java.io.IOException;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Web3jService {

    private final Web3j web3j;

    public String getBlockNumber() throws IOException {
        return web3j.ethBlockNumber().send().getBlockNumber().toString();
    }

    public String getGasPrice() throws IOException {
        return web3j.ethGasPrice().send().getGasPrice().toString();
    }

    public String getBalance() throws IOException {
        return web3j.ethGetBalance("", DefaultBlockParameter.valueOf("latest")).send().getBalance().toString();
    }

}