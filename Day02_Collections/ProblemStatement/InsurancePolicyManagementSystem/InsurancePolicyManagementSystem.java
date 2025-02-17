package Day02_Collections.ProblemStatement.InsurancePolicyManagementSystem;

import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManagementSystem {

    private static Map<String, Policy> policiesMap = new HashMap<>();
    private static Map<String, Policy> policiesLinkedMap = new LinkedHashMap<>();
    private static Map<String, Policy> policiesTreeMap = new TreeMap<>(Comparator.comparing(policyNumber -> policiesMap.get(policyNumber).getExpiryDate()));

    // Add policy to all maps
    public static void addPolicy(Policy policy) {
        policiesMap.put(policy.getPolicyNumber(), policy);
        policiesLinkedMap.put(policy.getPolicyNumber(), policy);
        policiesTreeMap.put(policy.getPolicyNumber(), policy);
    }

    // Retrieve a policy by its number
    public static Policy getPolicyByNumber(String policyNumber) {
        return policiesMap.get(policyNumber);
    }

    // List policies expiring within the next 30 days
    public static List<Policy> getPoliciesExpiringSoon() {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        LocalDate thirtyDaysLater = currentDate.plusDays(30);

        for (Policy policy : policiesMap.values()) {
            if (!policy.getExpiryDate().isBefore(currentDate) && !policy.getExpiryDate().isAfter(thirtyDaysLater)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public static List<Policy> getPoliciesByPolicyholder(String policyholderName) {
        List<Policy> policiesForHolder = new ArrayList<>();
        for (Policy policy : policiesMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                policiesForHolder.add(policy);
            }
        }
        return policiesForHolder;
    }

    // Remove expired policies
    public static void removeExpiredPolicies() {
        LocalDate currentDate = LocalDate.now();
        policiesMap.values().removeIf(policy -> policy.getExpiryDate().isBefore(currentDate));
        policiesLinkedMap.values().removeIf(policy -> policy.getExpiryDate().isBefore(currentDate));
        policiesTreeMap.values().removeIf(policy -> policy.getExpiryDate().isBefore(currentDate));
    }

    // Display policies from all maps
    public static void displayPolicies(Map<String, Policy> policyMap) {
        for (Policy policy : policyMap.values()) {
            System.out.println(policy);
        }
    }

    // Getter methods for private fields (for test purposes)
    public static Map<String, Policy> getPoliciesMap() {
        return policiesMap;
    }

    public static Map<String, Policy> getPoliciesLinkedMap() {
        return policiesLinkedMap;
    }

    public static Map<String, Policy> getPoliciesTreeMap() {
        return policiesTreeMap;
    }

    public static void main(String[] args) {
        // Sample Policies
        Policy policy1 = new Policy("P1001", "Alice", LocalDate.of(2025, 3, 15), "Health");
        Policy policy2 = new Policy("P1002", "Bob", LocalDate.of(2025, 2, 20), "Auto");
        Policy policy3 = new Policy("P1003", "Alice", LocalDate.of(2025, 4, 5), "Home");
        Policy policy4 = new Policy("P1004", "Carol", LocalDate.of(2025, 1, 30), "Health");

        // Add policies to all maps
        addPolicy(policy1);
        addPolicy(policy2);
        addPolicy(policy3);
        addPolicy(policy4);

        // Retrieve policy by number
        System.out.println("Retrieve Policy by Number (P1001): " + getPolicyByNumber("P1001"));

        // Policies expiring soon (within 30 days)
        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        List<Policy> expiringPolicies = getPoliciesExpiringSoon();
        for (Policy policy : expiringPolicies) {
            System.out.println(policy);
        }

        // Policies for a specific policyholder (Alice)
        System.out.println("\nPolicies for Policyholder Alice:");
        List<Policy> alicePolicies = getPoliciesByPolicyholder("Alice");
        for (Policy policy : alicePolicies) {
            System.out.println(policy);
        }

        // Remove expired policies
        System.out.println("\nRemoving Expired Policies...");
        removeExpiredPolicies();
        System.out.println("\nPolicies After Removing Expired:");
        displayPolicies(policiesMap);

        // Display policies sorted by expiry date (TreeMap)
        System.out.println("\nPolicies Sorted by Expiry Date (TreeMap):");
        displayPolicies(policiesTreeMap);
    }
}
