package Day05_Regex_JUnit.JUnit.AdvanceJunit_PracticeProblems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000.00);  // initial balance set to 1000
    }

    // Test deposit functionality
    @Test
    void testDeposit() {
        account.deposit(500.00);  // deposit 500
        assertEquals(1500.00, account.getBalance(), "Deposit failed to update balance correctly.");
    }

    // Test withdraw functionality
    @Test
    void testWithdraw() {
        boolean result = account.withdraw(300.00);  // withdraw 300
        assertTrue(result, "Withdrawal should be successful when funds are sufficient.");
        assertEquals(700.00, account.getBalance(), "Withdrawal did not update balance correctly.");
    }

    // Test withdrawal with insufficient funds
    @Test
    void testWithdrawInsufficientFunds() {
        boolean result = account.withdraw(2000.00);  // attempt to withdraw more than available balance
        assertFalse(result, "Withdrawal should fail when funds are insufficient.");
        assertEquals(1000.00, account.getBalance(), "Balance should not change when withdrawal fails.");
    }

    // Test deposit with a negative value
    @Test
    void testDepositNegativeAmount() {
        account.deposit(-100.00);  // attempt to deposit negative value
        assertEquals(1000.00, account.getBalance(), "Deposit of negative value should not change the balance.");
    }

    // Test withdrawing zero amount
    @Test
    void testWithdrawZeroAmount() {
        boolean result = account.withdraw(0.00);  // attempt to withdraw zero
        assertFalse(result, "Withdrawal of zero amount should fail.");
        assertEquals(1000.00, account.getBalance(), "Balance should remain unchanged when withdrawing zero.");
    }

    // Test withdrawal with exact balance
    @Test
    void testWithdrawExactBalance() {
        boolean result = account.withdraw(1000.00);  // withdraw entire balance
        assertTrue(result, "Withdrawal should succeed when withdrawing the exact balance.");
        assertEquals(0.00, account.getBalance(), "Balance should be zero after withdrawing the exact balance.");
    }
}
