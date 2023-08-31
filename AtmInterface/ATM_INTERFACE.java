import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

class bankAccount {
    int accountNumber;
    double balance;

    bankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        balance = initialBalance;
    }
}

class ATM {
    bankAccount account;

    ATM(bankAccount userAccount) {
        account = userAccount;
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (amount > account.balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        account.balance -= amount;
        System.out.printf("Withdrawn %.2f.%n", amount);
        System.out.println("Money withdraw successfully done");
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        account.balance += amount;
        System.out.printf("Deposited %.2f%n", amount);
        System.out.println("\nMoney deposit successfully");
    }

    void checkBalance() {
        System.out.printf("Current balance: %.2f%n", account.balance);
    }

    boolean verifyAccount(int accountNumber) {
        return accountNumber == account.accountNumber;
    }
}

class AccountHolder {
    String name;
    int accountNumber;

    AccountHolder(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }
}

public class ATM_INTERFACE {
    static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<AccountHolder> accountHolders = new ArrayList<>();

        AccountHolder accountHolder = new AccountHolder("Purna Chandra Pradhan", 1002001);
        accountHolders.add(accountHolder);

        Scanner sc = new Scanner(System.in);
        int accountNumber;
        int choice, ch;
        double amount;

        ATM atmMachine = null;

        do {
            System.out.println("Welcome to the ATM System!");
            for(int i=0; i<25;i++){
                System.out.print("*");
            }
            System.out.println();
            System.out.println("1. Log in");
            System.out.println("2. Create New Account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter your account number:");
                    accountNumber = sc.nextInt();

                    boolean isValidAccount = false;

                    for (AccountHolder hold : accountHolders) {
                        if (accountNumber == hold.accountNumber) {
                            isValidAccount = true;
                            accountHolder = hold;
                            bankAccount userAccount = new bankAccount(accountHolder.accountNumber, 1000.0);
                            atmMachine = new ATM(userAccount);
                            break;
                        }
                    }

                    if (isValidAccount) {
                        do {

                            System.out.println("ATM Menu:");
                            System.out.println("1. Withdraw");
                            System.out.println("2. Deposit");
                            System.out.println("3. Check Balance");
                            System.out.println("4. Exit");
                            System.out.print("Enter your choice: ");
                            ch = sc.nextInt();

                            switch (ch) {
                                case 1:
                                    System.out.print("Enter amount to withdraw: ");
                                    amount = sc.nextDouble();
                                    atmMachine.withdraw(amount);
                                    break;
                                case 2:
                                    System.out.print("Enter amount to deposit: ");
                                    amount = sc.nextDouble();
                                    atmMachine.deposit(amount);
                                    break;
                                case 3:
                                    atmMachine.checkBalance();
                                    break;
                                case 4:
                                    System.out.println("Exiting...");
                                    break;

                                default:
                                    System.out.println("Invalid choice.");
                            }
                        } while (ch != 4);
                        clearScreen();
                    } else {
                        System.out.println("Invalid account number.");
                    }
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    int newAccountNumber = accountHolders.size() + 1002001;
                    AccountHolder newAccountHolder = new AccountHolder(name, newAccountNumber);
                    accountHolders.add(newAccountHolder);

                    System.out.println("New account created:");
                    System.out.println("Account Number: " + newAccountHolder.accountNumber);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }
}
