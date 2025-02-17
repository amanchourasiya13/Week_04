package Day05_Regex_JUnit.JUnit.AdvanceJunit_PracticeProblems;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        // Create a BankAccount instance with an initial balance of 1000
        BankAccount account = new BankAccount(1000.00);

        // Display initial balance
        System.out.println("Initial Balance: " + account.getBalance());

        // Test deposit method
        account.deposit(500.00);
        System.out.println("Balance after depositing 500: " + account.getBalance());

        // Test withdraw method
        if (account.withdraw(300.00)) {
            System.out.println("Withdrawal of 300 successful.");
        } else {
            System.out.println("Withdrawal of 300 failed.");
        }
        System.out.println("Balance after withdrawal of 300: " + account.getBalance());

        // Test withdraw with insufficient funds
        if (account.withdraw(2000.00)) {
            System.out.println("Withdrawal of 2000 successful.");
        } else {
            System.out.println("Withdrawal of 2000 failed due to insufficient funds.");
        }
        System.out.println("Balance after failed withdrawal of 2000: " + account.getBalance());

        // Test deposit with negative value
        account.deposit(-100.00);
        System.out.println("Balance after depositing -100: " + account.getBalance());

        // Test withdraw zero amount
        if (account.withdraw(0.00)) {
            System.out.println("Withdrawal of 0 successful.");
        } else {
            System.out.println("Withdrawal of 0 failed.");
        }
        System.out.println("Balance after withdrawal of 0: " + account.getBalance());

        // Test withdraw exact balance
        if (account.withdraw(account.getBalance())) {
            System.out.println("Withdrawal of entire balance successful.");
        } else {
            System.out.println("Withdrawal of entire balance failed.");
        }
        System.out.println("Balance after withdrawing entire balance: " + account.getBalance());
    }
}

