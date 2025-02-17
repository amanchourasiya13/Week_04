package Day02_Collections.ProblemStatement.InsurancePolicyManagementSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

public class InsurancePolicyManagementSystemTest {

    private InsurancePolicyManagementSystem insuranceSystem;

    @BeforeEach
    void setUp() {
        insuranceSystem = new InsurancePolicyManagementSystem();

        // Add sample policies
        insuranceSystem.addPolicy(new Policy("P1001", "Alice", LocalDate.of(2025, 3, 15), "Health"));
        insuranceSystem.addPolicy(new Policy("P1002", "Bob", LocalDate.of(2025, 2, 20), "Auto"));
        insuranceSystem.addPolicy(new Policy("P1003", "Alice", LocalDate.of(2025, 4, 5), "Home"));
        insuranceSystem.addPolicy(new Policy("P1004", "Carol", LocalDate.of(2025, 1, 30), "Health"));
    }

    @Test
    void testAddPolicy() {
        Policy newPolicy = new Policy("P1005", "Dave", LocalDate.of(2025, 5, 10), "Life");
        insuranceSystem.addPolicy(newPolicy);

        assertNotNull(insuranceSystem.getPolicyByNumber("P1005"));
    }

    @Test
    void testGetPoliciesExpiringSoon() {
        List<Policy> expiringPolicies = insuranceSystem.getPoliciesExpiringSoon();
        assertEquals(1, expiringPolicies.size()); // P1002 should expire soon
    }

    @Test
    void testGetPoliciesByPolicyholder() {
        List<Policy> alicePolicies = insuranceSystem.getPoliciesByPolicyholder("Alice");
        assertEquals(2, alicePolicies.size());
    }

    @Test
    void testRemoveExpiredPolicies() {
        insuranceSystem.removeExpiredPolicies();
        assertNull(insuranceSystem.getPolicyByNumber("P1004"));  // P1004 is expired
    }

    @Test
    void testPoliciesSortedByExpiryDate() {
        insuranceSystem.displayPolicies(insuranceSystem.getPoliciesTreeMap());
    }
}