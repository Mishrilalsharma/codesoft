import java.util.*;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }
}
class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");

            int option = sc.nextInt();
            switch (option) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Please take your cash. Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount. Withdrawal failed.");
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    private void handleCheckBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount ac = new BankAccount(1000); 
        ATM atm = new ATM(ac);
        atm.start();
    }
}