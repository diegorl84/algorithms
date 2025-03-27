import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("$" + amount + " deposited. New balance is $" + this.balance + ".");
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        System.out.println("$" + amount + " withdrawn. New balance is $" + this.balance + ".");
    }

    public double getBalance() {
        return this.balance;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount("John Doe");
        System.out.println("Welcome, " + account.getBalance());
        while (true) {
            System.out.print("What would you like to do? (deposit/withdraw/exit): ");
            String action = scanner.nextLine().toLowerCase();
            if (action.equals("deposit")) {
                System.out.print("Enter amount to deposit: ");
                double amount = Double.parseDouble(scanner.nextLine());
                account.deposit(amount);
            } else if (action.equals("withdraw")) {
                System.out.print("Enter amount to withdraw: ");
                double amount = Double.parseDouble(scanner.nextLine());
                account.withdraw(amount);
            } else if (action.equals("exit")) {
                System.out.println("Thank you for banking with us.");
                break;
            } else {
                System.out.println("Invalid action. Please choose deposit, withdraw, or exit.");
            }
        }
        scanner.close();
    }
}
