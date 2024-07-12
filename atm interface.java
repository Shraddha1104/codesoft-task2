import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Your current balance is: $" + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance of $1000
        ATM atm = new ATM(account);
        atm.start();
    }
}
/*
 OUTPUT

 Welcome to the ATM
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Please select an option: 1
Enter amount to withdraw: 500
Withdrawal successful.

Welcome to the ATM
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Please select an option: 2
Enter amount to deposit: 400
Deposit successful.

Welcome to the ATM
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Please select an option: 3
Your current balance is: $900.0

Welcome to the ATM
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Please select an option: 4
Thank you for using the ATM. Goodbye!
 */