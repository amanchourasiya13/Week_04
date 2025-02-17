package Day04_Exceptions.BankTransactionSystem;

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account class with withdrawal logic
class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Withdraw method that throws custom exceptions
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        } else if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        // Creating a bank account with initial balance of 1000
        BankAccount account = new BankAccount(1000);

        // Sample withdrawals with exception handling
        try {
            account.withdraw(500);  // Valid withdrawal
            account.withdraw(2000); // This should throw InsufficientBalanceException
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());  // Handle insufficient balance exception
        }try{
            account.withdraw(-100);  // This should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Handle invalid amount exception
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}

