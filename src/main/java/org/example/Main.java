package org.example;

public class Main {
    public static void main(String[] args) {
        String str = "123.3";
        double a = Double.parseDouble(str);
        int b = (int) a;
        System.out.println((b - (b % 10)) / 10);
        System.out.println();
    }
}