package com.alvonellos.interview.service;

import com.alvonellos.interview.config.Web3jConfig;
import com.alvonellos.interview.exceptions.InterviewAPIException;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.MnemonicUtils;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.Transaction;

import java.io.IOException;
import java.math.BigInteger;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class Web3jService {

    private final Web3j web3j;
    private final Web3jConfig web3jConfig;

    public String getBlockNumber() throws IOException {
        return web3j.ethBlockNumber().send().getBlockNumber().toString();
    }

    public BigInteger getGasPrice() throws IOException {
        return web3j.ethGasPrice().send().getGasPrice();
    }

    public String getBalance(String address) throws IOException {
        log.info("Credentials loaded");
        log.info("Getting balance from eth address: " + address);
        return web3j.ethGetBalance(address, DefaultBlockParameter.valueOf("latest")).send().getBalance().toString();
    }

    public String getAdmin() {
        Credentials credentials = WalletUtils.loadBip39Credentials(
                web3jConfig.adminPassword,
                web3jConfig.adminKey
        );

        return credentials.getAddress();
    }

    public String ethTransfer(String to, String from, BigInteger amount) throws IOException {
        log.entering("Web3jService", "ethTransfer", new Object[]{to, from, amount});
        Transaction transaction = new Transaction(
                from,
                this.getNonce(),
                this.getGasPrice(),
                this.getGasLimit(),
                to,
                amount,
                null
        );
        val result = this.sendTransaction(transaction);
        log.exiting(this.getClass().getName(), "post", result);
        return result;
    }

    private BigInteger getGasLimit() throws IOException {
        return web3j.ethEstimateGas(Transaction.createEthCallTransaction(
                this.getAdmin(),
                this.getAdmin(),
                "0x0"
        )).send().getAmountUsed();
    }

    private BigInteger getNonce() throws IOException {
        return web3j.ethGetTransactionCount(
                this.getAdmin(),
                DefaultBlockParameter.valueOf("latest")
        ).send().getTransactionCount();
    }

    private String sendTransaction(Transaction transaction) throws IOException {
        try {
            return web3j.ethSendTransaction(transaction).send().getTransactionHash();
        } catch (IOException e) {
            log.severe(e.getMessage());
            throw e;
        }
    }
}