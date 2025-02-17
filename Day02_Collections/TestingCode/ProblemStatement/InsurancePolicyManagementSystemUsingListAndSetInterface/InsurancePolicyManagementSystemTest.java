package Day02_Collections.ProblemStatement.InsurancePolicyManagementSystemUsingListAndSetInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class InsurancePolicyManagementSystemTest {

    private InsurancePolicyManager manager;
    private Policy policy1;
    private Policy policy2;
    private Policy policy3;
    private Policy policy4;

    @BeforeEach
    void setUp() {
        manager = new InsurancePolicyManager();
        policy1 = new Policy("P1", "John Doe", LocalDate.now().plusMonths(1), "Health", 500.0);
        policy2 = new Policy("P2", "Jane Smith", LocalDate.now().plusMonths(2), "Auto", 200.0);
        policy3 = new Policy("P3", "Sam Brown", LocalDate.now().plusMonths(3), "Home", 350.0);
        policy4 = new Policy("P4", "Emily White", LocalDate.now().plusDays(15), "Health", 450.0);
    }

    @Test
    void testAddPolicy() {
        manager.addPolicy(policy1);
        manager.addPolicy(policy2);

        Set<Policy> policies = manager.getAllPolicies();
        assertEquals(2, policies.size(), "There should be 2 policies.");
        assertTrue(policies.contains(policy1), "Policy 1 should be present.");
        assertTrue(policies.contains(policy2), "Policy 2 should be present.");
    }

    @Test
    void testRemovePolicy() {
        manager.addPolicy(policy1);
        manager.addPolicy(policy2);

        manager.removePolicy(policy1);

        Set<Policy> policies = manager.getAllPolicies();
        assertEquals(1, policies.size(), "There should be 1 policy left.");
        assertFalse(policies.contains(policy1), "Policy 1 should be removed.");
        assertTrue(policies.contains(policy2), "Policy 2 should still be present.");
    }

    @Test
    void testGetPoliciesExpiringSoon() {
        manager.addPolicy(policy1);
        manager.addPolicy(policy4);

        Set<Policy> expiringSoon = manager.getPoliciesExpiringSoon();
        assertEquals(1, expiringSoon.size(), "There should be 1 policy expiring soon.");
        assertTrue(expiringSoon.contains(policy4), "Policy 4 should be expiring soon.");
    }

    @Test
    void testGetPoliciesByCoverageType() {
        manager.addPolicy(policy1);
        manager.addPolicy(policy2);
        manager.addPolicy(policy3);

        Set<Policy> healthPolicies = manager.getPoliciesByCoverageType("Health");
        assertEquals(1, healthPolicies.size(), "There should be 1 health policy.");
        assertTrue(healthPolicies.contains(policy1), "Policy 1 should be a health policy.");

        Set<Policy> autoPolicies = manager.getPoliciesByCoverageType("Auto");
        assertEquals(1, autoPolicies.size(), "There should be 1 auto policy.");
        assertTrue(autoPolicies.contains(policy2), "Policy 2 should be an auto policy.");
    }

    @Test
    void testGetDuplicatePolicies() {
        manager.addPolicy(policy1);
        manager.addPolicy(policy2);
        manager.addPolicy(policy1);  // Adding a duplicate policy

        Set<Policy> duplicates = manager.getDuplicatePolicies();
        assertEquals(1, duplicates.size(), "There should be 1 duplicate policy.");
        assertTrue(duplicates.contains(policy1), "Policy 1 should be marked as a duplicate.");
    }

    @Test
    void testPerformanceComparison() {
        manager.comparePerformance();  // Testing performance comparison (output to console)
    }
}
