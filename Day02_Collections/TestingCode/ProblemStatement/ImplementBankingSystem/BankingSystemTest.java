package Day02_Collections.ProblemStatement.ImplementBankingSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankingSystemTest {

    @BeforeEach
    public void setUp() {
        // Reset the BankingSystem state before each test
        BankingSystem.getAccounts().clear();
        BankingSystem.getWithdrawalRequests().clear();
    }

    @Test
    public void testAddAccount() {
        // Add an account
        BankingSystem.addAccount(1001, 500.00);

        // Assert that the account is added successfully
        assertTrue(BankingSystem.getAccounts().containsKey(1001));
        assertEquals(500.00, BankingSystem.getAccounts().get(1001));
    }

    @Test
    public void testDeposit() {
        // Add an account and deposit money
        BankingSystem.addAccount(1002, 300.00);
        BankingSystem.deposit(1002, 50.00);

        // Assert that the balance is updated correctly
        assertEquals(350.00, BankingSystem.getAccounts().get(1002));
    }

    @Test
    public void testWithdraw() {
        // Add an account and initiate a withdrawal
        BankingSystem.addAccount(1003, 1000.00);
        BankingSystem.withdraw(1003, 100.00);

        // Assert that the withdrawal request is added
        assertTrue(BankingSystem.getWithdrawalRequests().contains(1003));
    }

    @Test
    public void testProcessWithdrawal() {
        // Add an account and initiate a withdrawal
        BankingSystem.addAccount(1004, 500.00);
        BankingSystem.withdraw(1004, 100.00);

        // Process the withdrawal
        BankingSystem.processWithdrawal();

        // Assert that the balance is updated after withdrawal
        assertEquals(400.00, BankingSystem.getAccounts().get(1004));
    }

    @Test
    public void testInsufficientFunds() {
        // Add an account with low balance and try to withdraw more than available
        BankingSystem.addAccount(1005, 50.00);
        BankingSystem.withdraw(1005, 100.00);

        // Assert that the withdrawal request is not added
        assertTrue(BankingSystem.getWithdrawalRequests().isEmpty());
    }
}
