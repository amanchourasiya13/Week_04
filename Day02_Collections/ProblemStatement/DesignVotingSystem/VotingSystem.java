
package Day02_Collections.ProblemStatement.DesignVotingSystem;

import java.util.*;

public class VotingSystem {

    // HashMap to store votes for each candidate
    private static Map<String, Integer> voteCount = new HashMap<>();

    // LinkedHashMap to maintain the order of votes
    private static Map<String, Integer> voteOrder = new LinkedHashMap<>();

    // Method to cast a vote for a candidate
    public static void castVote(String candidate) {
        // Increment the vote in the HashMap
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);

        // Update the LinkedHashMap to maintain the order of votes
        voteOrder.put(candidate, voteCount.get(candidate));
    }

    // Method to display the results in sorted order by vote count
    public static void displayResults() {
        // Sort the results by vote count in descending order using a List
        List<Map.Entry<String, Integer>> sortedByVotes = new ArrayList<>(voteCount.entrySet());
        sortedByVotes.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Display the sorted results by vote count
        System.out.println("\nVoting Results (Sorted by Vote Count):");
        for (Map.Entry<String, Integer> entry : sortedByVotes) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }

        // Display the vote order using LinkedHashMap (preserving order of voting)
        System.out.println("\nVoting Order (Preserving Order of Votes):");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    // Getter methods for testing purposes
    public static Map<String, Integer> getVoteCount() {
        return voteCount;
    }

    public static Map<String, Integer> getVoteOrder() {
        return voteOrder;
    }

    public static void main(String[] args) {
        // Simulating some votes
        castVote("Alice");
        castVote("Bob");
        castVote("Alice");
        castVote("Charlie");
        castVote("Bob");
        castVote("Alice");

        // Display the voting results
        displayResults();
    }
}
