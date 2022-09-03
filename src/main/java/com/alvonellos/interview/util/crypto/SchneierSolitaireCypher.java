package com.alvonellos.interview.util.crypto;

import java.util.Arrays;
import java.util.HashMap;

public class SchneierSolitaireCypher {
    public enum Card {
        ACESPADE, TWOSPADE, THREESPADE, FOURSPADE, FIVESPADE, SIXSPADE, SEVENSPADE, EIGHTSPADE, NINESPADE, TENSPADE, JACKSPADE, QUEENSPADE, KINGSPADE,
        ACEHEARTS, TWOHEARTS, THREEHEARTS, FOURHEARTS, FIVEHEARTS, SIXHEARTS, SEVENHEARTS, EIGHTHEARTS, NINEHEARTS, TENHEARTS, JACKHEARTS, QUEENHEARTS, KINGHEARTS,
        ACEDIAMONDS, TWODIAMONDS, THREEDIAMONDS, FOURDIAMONDS, FIVEDIAMONDS, SIXDIAMONDS, SEVENDIAMONDS, EIGHTDIAMONDS, NINEDIAMONDS, TENDIAMONDS, JACKDIAMONDS, QUEENDIAMONDS, KINGDIAMONDS,
        ACECLUBS, TWOCLUBS, THREECLUBS, FOURCLUBS, FIVECLUBS, SIXCLUBS, SEVECLUBS, EIGHTCLUBS, NINECLUBS, TENCLUBS, JACKCLUBS, QUEENCLUBS, KINGCLUBS
    }
    public static Card[] getRandomCardDeck() {
        Card[] deck = new Card[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = Card.values()[i];
        }
        CryptoAlgorithms.shuffle(deck); // using secure rng
        return deck;
    }

    /**
     * Decode a message from the given keycode
     * NOTE: This method doesn't work and I don't know why. I'm leaving it here for reference.
     * @param ciphertext
     * @param deck
     * @return
     */
    public static String decrypt(String ciphertext, Card[] deck) {
        StringBuffer sb = new StringBuffer(ciphertext.toUpperCase());

        int curPos = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            curPos = i % 52;
            if(ciphertext.charAt(i) == ' ') {
                sb.setCharAt(i, ' ');
            } else {
                int tmp = sb.charAt(i) - 'A';    // Offset from 'A'
                int rotated = (tmp + deck[i].ordinal()+1) % 26; // Compute rotation, wrap at 26 for chars
                sb.setCharAt(i, (char) (rotated + 'A'));
            }
        }

        return sb.toString();
    }

    public static String encrypt(String plaintext, Card[] deck) {
        StringBuffer sb = new StringBuffer(plaintext.toUpperCase());

        int curPos = 0;
        for (int i = 0; i < plaintext.length(); i++) {
            curPos = i % 52;
            if(plaintext.charAt(i) == ' ') {
                sb.setCharAt(i, ' ');
            } else {
                int tmp = sb.charAt(i) - 'A';    // Offset from 'A'
                int rotated = (tmp + deck[i].ordinal()+1) % 26; // Compute rotation, wrap at 26 for chars
                sb.setCharAt(i, (char) (rotated + 'A'));
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String plaintext = "abcdefghijklmnopqrstuvwxyz";
        //get a random deck of cards
        Card[] deck = getRandomCardDeck();

        //print out the deck of cards
        System.out.println(Arrays.toString(deck));

        //encrypt the plaintext
        String ciphertext = encrypt(plaintext, deck);
        System.out.println(ciphertext);

        //decrypt the ciphertext
        String decrypted = decrypt(ciphertext, deck);
        System.out.println(decrypted);
    }
}
