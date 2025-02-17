package Day02_Collections.ProblemStatement.InsurancePolicyManagementSystem;

import java.time.LocalDate;

public class Policy {

    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;

    // Constructor
    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
    }

    // Getters and Setters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public void setPolicyholderName(String policyholderName) {
        this.policyholderName = policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Policyholder: " + policyholderName +
                ", Expiry Date: " + expiryDate + ", Coverage Type: " + coverageType;
    }
}
