package com.alvonellos.interview.util.crypto;

import org.junit.jupiter.api.Test;

import static com.alvonellos.interview.util.crypto.CryptoAlgorithms.*;

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

    @Test
    void decodeMessageTest() {
        final String key = "eljuxhpwnyrdgtqkviszcfmabo";
        final String cyphertext = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        final String plaintext = "the five boxing wizards jump quickly";

        assert(decodeMessage(key, cyphertext).equals(plaintext));
    }

    @Test
    void encodeMessageTest() {
        final String key = "eljuxhpwnyrdgtqkviszcfmabo";
        final String cyphertext = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        final String plaintext = "the five boxing wizards jump quickly";

        assert(encodeMessage(key, plaintext).equals(cyphertext));
    }
}