package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Student student = new Student("Duong", 10.0, 10.0, 10.0);
//        student.getResult();
//        Scanner scan = new Scanner(System.in);
//        scan.nextLine();
//        student.editGrade();

//        Fraction fraction1 = new Fraction(2, 4);
//        Fraction fraction2 = new Fraction(3, 6);
////        Fraction fraction3 = new Fraction()
//        System.out.println(fraction1.getFraction());
//        System.out.println(fraction2.getFraction());
//        System.out.println();
//        System.out.println(Fraction.plusFraction(fraction1, fraction2).getFraction());
//        System.out.println(Fraction.subtractFraction(fraction1, fraction2).getFraction());
//        System.out.println(Fraction.multiplyFraction(fraction1, fraction2).getFraction());
//        System.out.println(Fraction.simplifyFraction(fraction).getFraction());
//        System.out.println(fraction.getFraction());

        Banking bank = new Banking();

        Menu.add("BANK INFORMATION", () -> {
        });
        Menu.add("ADD BANK ACCOUNT", bank::addBankAccount);
        Menu.add("WITHDRAW MONEY", () -> {
        });
        Menu.add("DEPOSIT MONEY", () -> {
        });
        Menu.add("SHOW ALL ACCOUNT", bank::showAllBankAccounts);
        Menu.add("EXIT", () -> System.out.println("\t\t\t\t\t\t═════════════ EXIT ══════════════\t\t\t\t\t"));

        Menu.run();
    }
}