package com.alvonellos.interview.config;

import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Configuration
@Log
public class Web3jConfig implements InitializingBean {

    @Value("${web3j.client-address}")
    public String clientAddress;

    @Value("${web3j.admin-key}")
    public String adminKey;

    @Value("${web3j.admin-password}")
    public String adminPassword;

    @Value("${web3j.network-id}")
    public String networkId;

    @Bean
    @Primary
    public Web3j web3j() {
        assert(clientAddress != null);
        return Web3j.build(new HttpService(clientAddress));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        assert(clientAddress != null);
        assert(adminKey != null);
        assert(adminPassword != null);
        assert(networkId != null);

        log.config("Web3j client address: " + clientAddress);
        log.config("Web3j admin key: " + adminKey);
        log.config("Web3j admin password: " + adminPassword);
        log.config("Web3j network id: " + networkId);
    }
}
