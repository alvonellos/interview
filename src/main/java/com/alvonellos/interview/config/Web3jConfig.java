package com.alvonellos.interview.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Configuration
public class Web3jConfig {

    @Value("${web3j.client-address}")
    public String clientAddress;

    @Value("${web3j.admin-key}")
    public String adminKey;

    @Bean
    @Primary
    public Web3j web3j() {
        assert(clientAddress != null);
        return Web3j.build(new HttpService(clientAddress));
    }
}
