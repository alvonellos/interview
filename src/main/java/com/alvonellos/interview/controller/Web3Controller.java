package com.alvonellos.interview.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthAccounts;
import rx.Observable;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@Log
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Web3Controller {
    private final Web3j web3j;

    @GetMapping("/wallet")
    public List<String> getWallet() {
        try {

            EthAccounts accounts = web3j.ethAccounts().sendAsync().get();
            return accounts.getAccounts();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/gasPrice")
    public BigInteger getWeb3j() throws ExecutionException, InterruptedException {
        return web3j.ethGasPrice().sendAsync().get().getGasPrice();
    }

    @GetMapping("/balance/{address}")
    public BigInteger getBalance(@PathVariable("address") String address) throws IOException {
        return web3j.ethGetBalance(address, DefaultBlockParameter.valueOf("latest")).send().getBalance();
    }

    @GetMapping("/blockNumber")
    public BigInteger getBlockNumber() throws IOException {
        return web3j.ethBlockNumber().send().getBlockNumber();
    }

    @GetMapping("/transfer/{from}/{to}/{amount}")
    public String transfer(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("amount") BigInteger amount) throws IOException, ExecutionException, InterruptedException {
        return web3j.ethSendTransaction(
                Transaction.createEtherTransaction(
                        from,
                        null,
                        web3j.ethGasPrice().sendAsync().get().getGasPrice(),
                        null,
                        to,
                        amount)).send().getTransactionHash();
    }
}
