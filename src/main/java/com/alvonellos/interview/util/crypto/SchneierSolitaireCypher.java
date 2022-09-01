package com.alvonellos.interview.util.crypto;

public class SchneierSolitaireCypher {
    public enum Card {
        ACESPADE, TWOSPADE, THREESPADE, FOURSPADE, FIVESPADE, SIXSPADE, SEVENSPADE, EIGHTSPADE, NINESPADE, TENSPADE, JACKSPADE, QUEENSPADE, KINGSPADE,
        ACEHEARTS, TWOHEARTS, THREEHEARTS, FOURHEARTS, FIVEHEARTS, SIXHEARTS, SEVENHEARTS, EIGHTHEARTS, NINEHEARTS, TENHEARTS, JACKHEARTS, QUEENHEARTS, KINGHEARTS,
        ACEDIAMONDS, TWODIAMONDS, THREEDIAMONDS, FOURDIAMONDS, FIVEDIAMONDS, SIXDIAMONDS, SEVENDIAMONDS, EIGHTDIAMONDS, NINEDIAMONDS, TENDIAMONDS, JACKDIAMONDS, QUEENDIAMONDS, KINGDIAMONDS,
        ACECLUBS, TWOCLUBS, THREECLUBS, FOURCLUBS, FIVECLUBS, SIXCLUBS, SEVECLUBS, EIGHTCLUBS, NINECLUBS, TENCLUBS, JACKCLUBS, QUEENCLUBS, KINGCLUBS
    }
    public static final Integer[] SORTED_DECK = new Integer[] {};
    static {
        for (Card card : Card.values()) {
            SORTED_DECK[card.ordinal()] = card.ordinal();
        }
    }

    public Card[] getRandomCardDeck() {
        Card[] deck = new Card[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = Card.values()[i];
        }
        CryptoAlgorithms.shuffle(deck); // using secure rng
        return deck;
    }

    public static String decrypt(String ciphertext, Card[] cards_pos) {
        StringBuffer sb = new StringBuffer(ciphertext);


        return sb.toString();
    }

    public static String encrypt(String plaintext, Card[] cards_pos) {
        StringBuffer sb = new StringBuffer(plaintext);


        return cards_pos.toString() + "|" + sb.toString();
    }


    public static void main(String[] args) {

    }
}
