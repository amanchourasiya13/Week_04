
package Day04_Exceptions.BankTransactionSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTransactionSystemTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        // Create a BankAccount with an initial balance of 1000 before each test
        account = new BankAccount(1000);
    }

    @Test
    void testValidWithdrawal() {
        try {
            // Try to withdraw a valid amount (500)
            account.withdraw(500);
            assertTrue(true);  // If no exception is thrown, the test passes
        } catch (Exception e) {
            fail("Exception should not be thrown for valid withdrawal");
        }
    }

    @Test
    void testInsufficientBalance() {
        try {
            // Try to withdraw more than the balance (2000)
            account.withdraw(2000);
            fail("InsufficientBalanceException should be thrown");
        } catch (InsufficientBalanceException e) {
            assertEquals("Insufficient balance!", e.getMessage());
        } catch (Exception e) {
            fail("Wrong exception type was thrown: " + e.getMessage());
        }
    }

    @Test
    void testInvalidAmount() {
        try {
            // Try to withdraw a negative amount (-100)
            account.withdraw(-100);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid amount!", e.getMessage());
        } catch (Exception e) {
            fail("Wrong exception type was thrown: " + e.getMessage());
        }
    }
}
