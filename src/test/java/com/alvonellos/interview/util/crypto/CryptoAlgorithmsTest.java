package com.alvonellos.interview.util.crypto;

import org.junit.jupiter.api.Test;

import static com.alvonellos.interview.util.crypto.CryptoAlgorithms.nextPassword;
import static com.alvonellos.interview.util.crypto.CryptoAlgorithms.shuffle;

class CryptoAlgorithmsTest {

    @Test
    void nextPasswordTest() {
        System.err.println(nextPassword(25));
        assert(nextPassword(8).length() == 8);
    }

    @Test
    void shuffleTest() {
        System.err.println(shuffle("password"));
        assert(!shuffle("password").equals("password"));
    }
}