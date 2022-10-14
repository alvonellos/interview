package com.alvonellos.interview.util.numbers;

public class Fraction {
    int numerator;
    int denominator;
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        if(denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero");
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private int gcd(int numerator, int denominator) {
        if (denominator == 0) {
            return numerator;
        }
        return gcd(denominator, numerator % denominator);
    }

    public Fraction add(Fraction f) {
        int gcd = gcd(denominator, f.getDenominator());
        int lcm = (denominator * f.getDenominator()) / gcd;
        int newNumerator = (numerator * (lcm / denominator)) + (f.getNumerator() * (lcm / f.getDenominator()));
        numerator = newNumerator;
        denominator = lcm;
        return new Fraction(newNumerator, lcm);
    }

    public Fraction subtract(Fraction f) {
        int gcd = gcd(denominator, f.getDenominator());
        int lcm = (denominator * f.getDenominator()) / gcd;
        int newNumerator = (numerator * (lcm / denominator)) - (f.getNumerator() * (lcm / f.getDenominator()));
        numerator = newNumerator;
        denominator = lcm;
        return new Fraction(newNumerator, lcm);
    }

    public Fraction multiply(Fraction f) {
        int newNumerator = numerator * f.getNumerator();
        int newDenominator = denominator * f.getDenominator();
        numerator = newNumerator;
        denominator = newDenominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction f) {
        int newNumerator = numerator * f.getDenominator();
        int newDenominator = denominator * f.getNumerator();
        numerator = newNumerator;
        denominator = newDenominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        return new Fraction(numerator, denominator);
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public String toPercent(int precision) {
        return String.format("%." + precision + "f", toDouble() * 100) + "%";
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Fraction) {
            Fraction f = (Fraction) o;
            return f.getNumerator() == numerator && f.getDenominator() == denominator;
        }
        return false;
    }

    @Override public String toString() {
        return numerator + "/" + denominator;
    }

}