package Day02_Collections.ProblemStatement.InsurancePolicyManagementSystemUsingListAndSetInterface;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

 class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters and setters

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }
}
 class InsurancePolicyManager {

    private Set<Policy> hashSetPolicies;
    private Set<Policy> linkedHashSetPolicies;
    private Set<Policy> treeSetPolicies;

    public InsurancePolicyManager() {
        hashSetPolicies = new HashSet<>();
        linkedHashSetPolicies = new LinkedHashSet<>();
        treeSetPolicies = new TreeSet<>((p1, p2) -> p1.getExpiryDate().compareTo(p2.getExpiryDate()));
    }

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void removePolicy(Policy policy) {
        hashSetPolicies.remove(policy);
        linkedHashSetPolicies.remove(policy);
        treeSetPolicies.remove(policy);
    }

    public Set<Policy> getAllPolicies() {
        return hashSetPolicies;
    }

    public Set<Policy> getPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysFromNow = today.plusDays(30);
        return hashSetPolicies.stream()
                .filter(policy -> policy.getExpiryDate().isBefore(thirtyDaysFromNow) && policy.getExpiryDate().isAfter(today))
                .collect(Collectors.toSet());
    }

    public Set<Policy> getPoliciesByCoverageType(String coverageType) {
        return hashSetPolicies.stream()
                .filter(policy -> policy.getCoverageType().equalsIgnoreCase(coverageType))
                .collect(Collectors.toSet());
    }

    public Set<Policy> getDuplicatePolicies() {
        Set<Policy> duplicates = new HashSet<>();
        Set<String> policyNumbers = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    public void comparePerformance() {
        // Performance comparison logic
        long startTime, endTime;

        // Adding policies
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            addPolicy(new Policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i), "Health", 100.0));
        }
        endTime = System.nanoTime();
        System.out.println("HashSet - Add Time: " + (endTime - startTime) + " ns");

        // Removing policies
        startTime = System.nanoTime();
        removePolicy(new Policy("P1", "Holder1", LocalDate.now().plusDays(1), "Health", 100.0));
        endTime = System.nanoTime();
        System.out.println("HashSet - Remove Time: " + (endTime - startTime) + " ns");

        // Searching policies
        startTime = System.nanoTime();
        hashSetPolicies.contains(new Policy("P500", "Holder500", LocalDate.now(), "Auto", 150.0));
        endTime = System.nanoTime();
        System.out.println("HashSet - Search Time: " + (endTime - startTime) + " ns");
    }

}
public class InsurancePolicyManagementSystem {

    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        Policy p1 = new Policy("P1", "John Doe", LocalDate.now().plusMonths(1), "Health", 500.0);
        Policy p2 = new Policy("P2", "Jane Smith", LocalDate.now().plusMonths(2), "Auto", 200.0);
        Policy p3 = new Policy("P3", "Sam Brown", LocalDate.now().plusMonths(3), "Home", 350.0);
        Policy p4 = new Policy("P4", "Emily White", LocalDate.now().plusDays(15), "Health", 450.0);

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);

        // Displaying all policies
        System.out.println("All Policies:");
        manager.getAllPolicies().forEach(System.out::println);

        // Policies expiring soon
        System.out.println("\nPolicies Expiring Soon:");
        manager.getPoliciesExpiringSoon().forEach(System.out::println);

        // Policies with a specific coverage type
        System.out.println("\nHealth Policies:");
        manager.getPoliciesByCoverageType("Health").forEach(System.out::println);

        // Duplicate Policies
        System.out.println("\nDuplicate Policies:");
        manager.getDuplicatePolicies().forEach(System.out::println);

        // Performance comparison
        System.out.println("\nPerformance Comparison:");
        manager.comparePerformance();
    }
}
