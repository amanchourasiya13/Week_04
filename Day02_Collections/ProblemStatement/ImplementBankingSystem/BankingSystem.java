package Day02_Collections.ProblemStatement.ImplementBankingSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

class BankingSystem {

    // HashMap to store customer accounts (AccountNumber -> Balance)
    private static Map<Integer, Double> accounts = new HashMap<>();

    // TreeMap to sort customers by balance (Balance -> AccountNumber)
    private static Map<Double, List<Integer>> sortedAccounts = new TreeMap<>();

    // Queue to process withdrawal requests
    private static Queue<Integer> withdrawalRequests = new LinkedList<>();

    // Method to add a new account
    public static void addAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.putIfAbsent(initialBalance, new ArrayList<>());
        sortedAccounts.get(initialBalance).add(accountNumber);
    }

    // Method to deposit money into an account
    public static void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            double oldBalance = accounts.get(accountNumber);

            // Remove the old balance from TreeMap
            sortedAccounts.get(oldBalance).remove(Integer.valueOf(accountNumber));
            if (sortedAccounts.get(oldBalance).isEmpty()) {
                sortedAccounts.remove(oldBalance);
            }

            // Update balance in accounts map
            accounts.put(accountNumber, newBalance);

            // Add the new balance to the TreeMap
            sortedAccounts.putIfAbsent(newBalance, new ArrayList<>());
            sortedAccounts.get(newBalance).add(accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Method to initiate a withdrawal request
    public static void withdraw(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                withdrawalRequests.offer(accountNumber);
            } else {
                System.out.println("Insufficient funds for withdrawal from account " + accountNumber);
            }
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Method to process the next withdrawal request
    public static void processWithdrawal() {
        if (!withdrawalRequests.isEmpty()) {
            int accountNumber = withdrawalRequests.poll();
            double currentBalance = accounts.get(accountNumber);
            System.out.println("Processing withdrawal for account: " + accountNumber + " with balance: $" + currentBalance);

            // Perform the withdrawal (just an example, actual amount isn't subtracted here for simplicity)
            double newBalance = currentBalance - 100;  // Assume each withdrawal is $100 for simplicity
            accounts.put(accountNumber, newBalance);
            System.out.println("New balance for account " + accountNumber + ": $" + newBalance);
        } else {
            System.out.println("No pending withdrawal requests.");
        }
    }

    // Method to display all accounts sorted by balance
    public static void displaySortedAccounts() {
        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, List<Integer>> entry : sortedAccounts.entrySet()) {
            for (int accountNumber : entry.getValue()) {
                System.out.println("Account " + accountNumber + ": $" + entry.getKey());
            }
        }
    }

    // Method to display all customer accounts
    public static void displayAccounts() {
        System.out.println("All customer accounts:");
        accounts.forEach((accountNumber, balance) -> System.out.println("Account " + accountNumber + ": $" + balance));
    }

    // Getter methods for private fields to allow access in tests
    public static Map<Integer, Double> getAccounts() {
        return accounts;
    }

    public static Queue<Integer> getWithdrawalRequests() {
        return withdrawalRequests;
    }

    public static void main(String[] args) {
        // Add some accounts
        addAccount(1001, 500.00);
        addAccount(1002, 300.00);
        addAccount(1003, 1000.00);

        // Deposit into accounts
        deposit(1001, 200.00);
        deposit(1002, 50.00);

        // Initiate some withdrawals
        withdraw(1001, 100.00);
        withdraw(1003, 150.00);

        // Process withdrawals
        processWithdrawal();
        processWithdrawal();

        // Display all accounts
        displayAccounts();

        // Display sorted accounts by balance
        displaySortedAccounts();
    }
}
