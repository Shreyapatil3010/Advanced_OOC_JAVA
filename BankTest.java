import java.util.Scanner;

class LowBalanceException extends Exception {
    LowBalanceException(String message) {
        super(message);
    }
}

class NegativeNumberException extends Exception {
    NegativeNumberException(String message) {
        super(message);
    }
}

class BankAccount {

    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void balanceEnquiry() {
        System.out.println("Current Balance: " + balance);
    }

    void deposit(double amount) throws NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Cannot deposit negative amount");
        }
        balance += amount;
        System.out.println("Amount Deposited: " + amount);
    }

    void withdraw(double amount) throws LowBalanceException, NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Cannot withdraw negative amount");
        }
        if (amount > balance) {
            throw new LowBalanceException("Insufficient Balance");
        }
        balance -= amount;
        System.out.println("Amount Withdrawn: " + amount);
    }
}

public class BankTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        BankAccount account = new BankAccount(bal);

        try {
            System.out.print("Enter Deposit Amount: ");
            double dep = sc.nextDouble();
            account.deposit(dep);

            System.out.print("Enter Withdraw Amount: ");
            double wd = sc.nextDouble();
            account.withdraw(wd);

            account.balanceEnquiry();

        } catch (NegativeNumberException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (LowBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}