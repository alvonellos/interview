package com.alvonellos.interview.util.crypto;

import org.junit.jupiter.api.Test;

import java.util.Locale;

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
        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        key += key.toUpperCase(Locale.ROOT);
        final String cyphertext = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        final String plaintext = "the five boxing wizards jump quickly";

        assert(decodeMessage(key, cyphertext).equals(plaintext));
    }

    @Test
    void encodeMessageTest() {
        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        key += key.toUpperCase(Locale.ROOT);

        final String cyphertext = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        final String plaintext = "the five boxing wizards jump quickly";

        assert(encodeMessage(key, plaintext).equals(cyphertext));
    }

    @Test
    void rotate13Test() {
        assert(rotate13Encode("the quick brown fox jumps over the lazy dog")
                .equals("gur dhvpx oebja sbk whzcf bire gur ynml qbt"));

        assert(rotate13Decode("gur dhvpx oebja sbk whzcf bire gur ynml qbt")
                .equals("the quick brown fox jumps over the lazy dog"));
    }

    @Test
    void strongPasswordCheckerTest() {
        assert(strongPasswordChecker("a") == 5);
    }
}