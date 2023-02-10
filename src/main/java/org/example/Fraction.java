package org.example;

import java.util.ArrayList;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        setNumerator(1);
        setDenominator(1);
    }

    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
    }

    public String getFraction() {
        Fraction fraction = simplifyFraction(new Fraction(numerator, denominator));
        return fraction.getNumerator() + " / " + fraction.getDenominator();
    }

    public static Fraction subtractFraction(Fraction fraction1, Fraction fraction2) {
        Fraction fraction = new Fraction();
        if (fraction.getDenominator() == fraction2.getDenominator()) {
            fraction.setNumerator(fraction1.getNumerator() - fraction2.getNumerator());
            fraction.setDenominator(fraction1.getDenominator());
        } else {
            fraction.setNumerator((fraction1.getNumerator() * fraction2.getDenominator()) - (fraction2.getNumerator() * fraction1.getDenominator()));
            fraction.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());
        }

        return fraction;
    }

    public static Fraction plusFraction(Fraction fraction1, Fraction fraction2) {
        Fraction fraction = new Fraction();

        if (fraction.getDenominator() == fraction2.getDenominator()) {
            fraction.setNumerator(fraction1.getNumerator() + fraction2.getNumerator());
            fraction.setDenominator(fraction1.getDenominator());
        } else {
            fraction.setNumerator((fraction1.getNumerator() * fraction2.getDenominator()) + (fraction2.getNumerator() * fraction1.getDenominator()));
            fraction.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());
        }

        return fraction;
    }

    public static Fraction multiplyFraction(Fraction fraction1, Fraction fraction2) {
        Fraction fraction = new Fraction();

        fraction.setNumerator(fraction1.getNumerator() * fraction2.getNumerator());
        fraction.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());

        return fraction;
    }

    public static Fraction simplifyFraction(Fraction fraction1) {
        if (fraction1.getNumerator() == fraction1.getDenominator()) {
            fraction1.setNumerator(1);
            fraction1.setDenominator(1);

            return fraction1;
        }

        int gcd = 1;
        int a = Math.max(fraction1.getNumerator(), fraction1.getDenominator());

        for (int i = 1; i <= a / 2; i++) {
            if (fraction1.getNumerator() % i == 0 && fraction1.getDenominator() % i == 0) {
                gcd = i;
            }
        }

        fraction1.setNumerator(fraction1.getNumerator() / gcd);
        fraction1.setDenominator(fraction1.getDenominator() / gcd);

        return fraction1;
    }
}
