package org.example;

import java.util.*;

public class Banking {
    private static final ArrayList<BankAccount> _banking_account = new ArrayList<BankAccount>();

    public Banking() {
        _banking_account.add(new BankAccount("Duong", 20, "male"));
        _banking_account.add(new BankAccount("Thu", 20, "female"));
        _banking_account.add(new BankAccount("Man", 20, "female"));
        _banking_account.add(new BankAccount("Nghia", 20, "male"));
        _banking_account.add(new BankAccount("Phuc", 20, "male"));
    }

    public String Repeat(String character, int count) {
        return character.repeat(count);
    }

    public static int AccountCount() {
        return _banking_account.size();
    }

    public void addBankAccount() {
        System.out.println("\t\t\t\t\t\t════════════ ADDING NEW ACCOUNT ═════════════\t\t\t\t\t");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Account User's Name: ");
        String name = scanner.next();
        System.out.print("Account User's Age: ");
        int age = scanner.nextInt();
        System.out.print("Account User's Sex (Integer Input (1, 2) -> 1. Male | 2. Female): ");
        int sexChoice = scanner.nextInt();
        String sex;

        switch (sexChoice) {
            case 1 -> sex = "Male";
            case 2 -> sex = "Female";
            default -> {
                System.out.println("Invalid Input Sex");
                return;
            }
        }

        BankAccount bankAccount = new BankAccount(name, age, sex);
        _banking_account.add(bankAccount);

        System.out.println("\t\t\t\t\t\t═══════════ ADDED SUCCESSFULLY ═══════════\t\t\t\t\t");
        scanner.nextLine();
    }

    public void withdrawTransaction(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Withdraw System is being initialized...");

        while (true) {
            System.out.print("Amount of money to withdraw: ");
            double amount = scanner.nextDouble();

            if (amount < 0) {
                System.out.println("Invalid withdraw input... Try again");
                System.out.println("Do you want to continue the transaction (YES or NO): ");
                String continueTransaction = scanner.next().toLowerCase();

                if (continueTransaction.equals("no")) {
                    return;
                }
            } else {
                if (amount > _banking_account.get(id - 1).getBalance()) {
                    System.out.println("Amount of withdraw money exceeds the balance... Try again");
                    System.out.print("Do you want to continue the transaction (YES or NO): ");
                    String continueTransaction = scanner.next().toLowerCase();

                    if (continueTransaction.equals("no")) {
                        return;
                    }
                } else {
                    System.out.print("Confirm the withdraw amount ( " + amount + " ) (TYPE CONFIRM): ");
                    String confirm = scanner.next().toLowerCase();

                    if (!confirm.equals("confirm")) {
                        System.out.println("Cancel withdraw successfully");
                        return;
                    }

                    _banking_account.get(id - 1).setBalance(_banking_account.get(id - 1).getBalance() - amount);
                    _banking_account.get(id - 1).setLogs(new BankAccount.Log("Withdraw", "Withdraw: " + amount + "$"));
                    System.out.println("\t\t\t\t\t\t═══════════ WITHDRAW SUCCESSFULLY ═══════════\t\t\t\t\t");
                    break;
                }
            }
        }
    }

    public void depositTransaction(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deposit System is being initialized...");

        while (true) {
            System.out.print("Amount of money to deposit: ");
            double amount = scanner.nextDouble();

            if (amount < 0) {
                System.out.println("Invalid deposit input... Try again");
                System.out.print("Do you want to continue the transaction (YES or NO): ");
                String continueTransaction = scanner.next().toLowerCase();

                if (continueTransaction.equals("no")) {
                    return;
                }
            } else {
                System.out.print("Confirm the deposit amount ( " + amount + " ) (TYPE CONFIRM): ");
                String confirm = scanner.next().toLowerCase();

                if (!confirm.equals("confirm")) {
                    System.out.println("Cancel deposit successfully");
                    return;
                }

                _banking_account.get(id - 1).setBalance(_banking_account.get(id - 1).getBalance() + amount);
                _banking_account.get(id - 1).setLogs(new BankAccount.Log("Deposit", "Deposit: " + amount + "$"));
                System.out.println("\t\t\t\t\t\t═══════════ DEPOSIT SUCCESSFULLY ═══════════\t\t\t\t\t");
                break;
            }
        }
    }

    public void transferTransaction(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Transfer System is being initialized...");

        while (true) {
            System.out.print("Input Receiver's ID: ");
            int i = scanner.nextInt();

            if (i > AccountCount() && i < 0) {
                System.out.println("Invalid Receiver's ID or this Receiver's ID is not exist...");
                return;
            }

            if (i == id) {
                System.out.println("You cannot transfer yourself...");
                return;
            }

            System.out.print("Amount of money to Transfer: ");
            double amount = scanner.nextDouble();

            if (amount < 0) {
                System.out.println("Invalid Transfer input... Try again");
                System.out.println("Do you want to continue the transaction (YES or NO): ");
                String continueTransaction = scanner.next().toLowerCase();

                if (continueTransaction.equals("no")) {
                    return;
                }
            } else {
                if (amount > _banking_account.get(id - 1).getBalance()) {
                    System.out.println("Amount of Transfer money exceeds the balance... Try again");
                    System.out.print("Do you want to continue the transaction (YES or NO): ");
                    String continueTransaction = scanner.next().toLowerCase();

                    if (continueTransaction.equals("no")) {
                        return;
                    }
                } else {
                    System.out.print("Confirm the Receiver's ID ( " + i + " ) (TYPE CONFIRM): ");
                    String confirmId = scanner.next().toLowerCase();
                    System.out.print("Confirm the Transfer amount ( " + amount + " ) (TYPE CONFIRM): ");
                    String confirm = scanner.next().toLowerCase();

                    if (!(confirmId.equals("confirm") && confirm.equals("confirm"))) {
                        System.out.println("Cancel deposit successfully");
                        return;
                    }

                    _banking_account.get(id - 1).setBalance(_banking_account.get(id - 1).getBalance() - amount);
                    _banking_account.get(i - 1).setBalance(_banking_account.get(i - 1).getBalance() + amount);

                    _banking_account.get(id - 1).setLogs(new BankAccount.Log("Transfer", "Transfer: " + amount + "$ to -> " + i));
                    System.out.println("\t\t\t\t\t\t═══════════ TRANSFER SUCCESSFULLY ═══════════\t\t\t\t\t");
                    break;
                }
            }
        }
    }

    public void showAllBankAccounts() {
        System.out.println("\t\t\t\t\t\t═══════════ GETTING BANKING DATA ═══════════\t\t\t\t\t");
        Scanner scanner = new Scanner(System.in);
        int[] arr = {5, 80, 5, 8, 10, 50};

        for (int k : arr) {
            System.out.print("╔" + Repeat("═", k) + "╗");
        }

        System.out.println();

        System.out.println(
                "║ ID" + String.format("%-2s", "") + "║" +
                        "║ Name" + String.format("%-75s", "") + "║" +
                        "║ Age" + String.format("%-1s", "") + "║" +
                        "║ Sex" + String.format("%-4s", "") + "║" +
                        "║ Balance" + String.format("%-2s", "") + "║" +
                        "║ Log" + String.format("%-46s", "") + "║"
        );

        for (BankAccount account : _banking_account) {
            for (int j : arr) {
                System.out.print(" " + Repeat("═", j) + " ");
            }

            System.out.println();

            System.out.print(
                    "║ " + account.getID() + String.format("%-" + (4 - Integer.toString(account.getID()).length()) + "s", "") + "║" +
                            "║ " + account.getName() + String.format("%-" + (79 - account.getName().length()) + "s", "") + "║" +
                            "║ " + account.getAge() + String.format("%-" + (4 - Integer.toString(account.getAge()).length()) + "s", "") + "║" +
                            "║ " + account.getSex().substring(0, 1).toUpperCase() + account.getSex().substring(1)
                            + String.format("%-" + (7 - account.getSex().length()) + "s", "") + "║" +
                            "║ " + account.getBalance() + "$" + String.format("%-" + (8 - Double.toString(account.getBalance()).length()) + "s", "") + "║"
            );

            if (account.getLogs().size() > 0) {
                for (int i = 0; i < account.getLogs().size(); i++) {
                    System.out.print("║ " + account.getLogs().get(i).getLogCommit()
                            + String.format("%-" + (49 - account.getLogs().get(i).getLogCommit().length()) + "s", "") + "║");

                    if (i != account.getLogs().size() - 1) {
                        System.out.print(
                                "\n║" + String.format("%-5s", "") + "║" +
                                        "║" + String.format("%-80s", "") + "║" +
                                        "║" + String.format("%-5s", "") + "║" +
                                        "║" + String.format("%-8s", "") + "║" +
                                        "║" + String.format("%-10s", "") + "║"
                        );
                    } else {
                        System.out.println();
                    }
                }
            } else {
                System.out.println("║ " + "No transaction occurred" + String.format("%-26s", "") + "║");
            }
        }

        for (int j : arr) {
            System.out.print("╚" + Repeat("═", j) + "╝");
        }

        System.out.println();

        System.out.println("\t\t\t\t\t\t╔═════════════════ MENU ═════════════════╗\t\t\t\t\t");
        System.out.println("\t\t\t\t\t\t║ 01. ACCOUNT TRANSACTION                ║\t\t\t\t\t");
        System.out.println("\t\t\t\t\t\t║ 02. EXIT                               ║\t\t\t\t\t");
        System.out.println("\t\t\t\t\t\t╚════════════════════════════════════════╝\t\t\t\t\t");

        System.out.print("Select: ");
        int na = scanner.nextInt();

        if (na == 2) {
            return;
        } else if (na > 2 || na < 0) {
            System.out.println("Invalid input...");
            return;
        }

        System.out.print("Select Specific Customer for more details: ");
        int id = scanner.nextInt();

        if (id <= AccountCount()) {
            System.out.println("\n\t\t\t\t\t\t             Customer No." + id);
            System.out.println("\t\t\t\t\t\t╔═════════════════ MENU ═════════════════╗\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t║ 01. WITHDRAW                           ║\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t║ 02. DEPOSIT                            ║\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t║ 03. TRANSFER                           ║\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t║ 04. EXIT                               ║\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t╚════════════════════════════════════════╝\t\t\t\t\t");

            System.out.print("Select transaction: ");
            int n = scanner.nextInt();

            switch (n) {
                case 1:
                    withdrawTransaction(id);
                    break;
                case 2:
                    depositTransaction(id);
                    break;
                case 3:
                    transferTransaction(id);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid input...");
                    break;
            }
        } else {
            System.out.println("User not found...");
        }

        scanner.nextLine();
    }
}
