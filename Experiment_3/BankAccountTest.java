class BankAccount
{
    double balance;

    BankAccount(double balance)
    {
        this.balance = balance;
    }

    void deposit(double amount)
    {
        balance = balance + amount;
        System.out.println("Balance after deposit: " + balance);
    }

    void withdraw(double amount)
    {
        balance = balance - amount;
        System.out.println("Balance after withdrawal: " + balance);
    }
}

class SavingsAccount extends BankAccount
{
    SavingsAccount(double balance)
    {
        super(balance);
    }

    void withdraw(double amount)
    {
        if (balance - amount < 100)
        {
            System.out.println("Withdrawal not allowed. Balance below 100");
        }
        else
        {
            balance = balance - amount;
            System.out.println("Balance after withdrawal: " + balance);
        }
    }
}

public class BankAccountTest
{
    public static void main(String[] args)
    {
        SavingsAccount sa = new SavingsAccount(500);
        sa.deposit(200);
        sa.withdraw(550);
        sa.withdraw(200);
    }
}