package org.example;

import java.util.Scanner;

public class Student {
    private String name;
    private double mathGrade;
    private double englishGrade;
    private double computerScience;

    public Student(String name, double math, double english, double computerScience) {
        this.name = name;
        this.mathGrade = math;
        this.englishGrade = english;
        this.computerScience = computerScience;
    }

    public void getResult() {
        double result = (mathGrade + englishGrade + computerScience) / 3;
        System.out.println("Name: " + name);

        if (result >= 8.0) {
            System.out.println("Grade: Distinction");
        } else if (5.0 <= result || result < 8.0) {
            System.out.println("Grade: Pass");
        } else {
            System.out.println("Grade: Failed");
        }
    }

    public void editGrade() {
        System.out.println("----- Edit ----");
        System.out.println("1. Math");
        System.out.println("2. English");
        System.out.println("3. Computer Science");
        System.out.print("Input which subject to edit: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        switch (n) {
            case 1:
                mathGrade = readSubjectGrade("Math", mathGrade);
                System.out.println("Edit Successfully");
                break;
            case 2:
                englishGrade = readSubjectGrade("English", englishGrade);
                System.out.println("Edit Successfully");
                break;
            case 3:
                computerScience = readSubjectGrade("Computer Science", computerScience);
                System.out.println("Edit Successfully");
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private double readSubjectGrade(String subject, double grade) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(subject + " " + grade + " -> ");

        return scanner.nextDouble();
    }
}
