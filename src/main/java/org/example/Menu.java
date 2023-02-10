package org.example;

import java.util.*;

public class Menu {
    private static final ArrayList<String> choice = new ArrayList<>();
    private static final ArrayList<Runnable> choiceFunction = new ArrayList<>();

    public static void run() {
        while (true) {
            System.out.println("\n\t\t\t\t\t\t╔═════════════════ MENU ═════════════════╗");

            for (int i = 0; i < choice.size(); i++) {
                System.out.println("\t\t\t\t\t\t║ " + (i < 10 ? "0" + (i + 1) : i + 1) + ". " + choice.get(i)
                        + String.format("%-" + (35 - choice.get(i).length()) + "s", "") + "║");
            }

            System.out.println("\t\t\t\t\t\t╚════════════════════════════════════════╝");
            System.out.print("Input to use: ");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();

            if (number > choice.size() || number < 0) {
                System.out.println("Invalid input...");
                return;
            }

            choiceFunction.get(number - 1).run();

            if (number == choice.size()) {
                return;
            }
        }
    }

    public static void add(String name, Runnable function) {
        choice.add(name);
        choiceFunction.add(function);
    }
}
