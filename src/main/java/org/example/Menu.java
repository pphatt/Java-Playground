package org.example;
import java.util.Scanner;

public class Menu {
    public Menu() {
        Banking bank = new Banking();

        while (true) {
            System.out.println("\n\t\t\t\t\t\t             BANKING SYSTEM             \t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t╔═════════════════ MENU ═════════════════╗\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t║ 01. BANK INFORMATION                   ║\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t║ 02. ADD BANK ACCOUNT                   ║\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t║ 03. WITHDRAW MONEY                     ║\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t║ 04. DEPOSIT MONEY                      ║\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t║ 05. SHOW ALL ACCOUNT                   ║\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t║ 06. EXIT                               ║\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t╚════════════════════════════════════════╝\t\t\t\t\t");
            System.out.print("Input to use: ");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    break;
                case 2:
                    bank.addBankAccount();
                    break;
                case 5:
                    bank.showAllBankAccounts();
                    break;
                case 6:
                    System.out.println("\t\t\t\t\t\t═════════════ EXIT ══════════════\t\t\t\t\t");
                    return;
                default:
                    return;
            }
        }
    }
}
