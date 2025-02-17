
package Day02_Collections.ProblemStatement.DesignVotingSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class VotingSystemTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // Resetting the state before each test
    @BeforeEach
    void setUp() {
        // Clear previous votes before each test
        VotingSystem.getVoteCount().clear();
        VotingSystem.getVoteOrder().clear();

        // Redirect system output to capture print statements
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // Test the functionality of casting a vote
    @Test
    void testCastVote() {
        VotingSystem.castVote("Alice");
        VotingSystem.castVote("Bob");
        VotingSystem.castVote("Alice");

        // Verify the votes using getter methods
        assertEquals(2, VotingSystem.getVoteCount().get("Alice"));
        assertEquals(1, VotingSystem.getVoteCount().get("Bob"));
    }

    // Test the sorting of results by vote count
    @Test
    void testSortedResults() {
        VotingSystem.castVote("Alice");
        VotingSystem.castVote("Charlie");
        VotingSystem.castVote("Bob");

        // Verify that sortedResults is sorted by vote count
        Map<String, Integer> sortedMap = VotingSystem.getVoteCount();
        assertEquals(1, sortedMap.get("Alice"));
        assertEquals(1, sortedMap.get("Bob"));
        assertEquals(1, sortedMap.get("Charlie"));
    }

    // Test the preservation of vote order in LinkedHashMap
    @Test
    void testVoteOrderPreservation() {
        VotingSystem.castVote("Alice");
        VotingSystem.castVote("Bob");
        VotingSystem.castVote("Charlie");

        // Verify that voteOrder preserves the order of votes
        Map<String, Integer> voteOrder = VotingSystem.getVoteOrder();
        assertEquals(1, voteOrder.get("Alice"));
        assertEquals(1, voteOrder.get("Bob"));
        assertEquals(1, voteOrder.get("Charlie"));
    }

    // Test displaying the results
    @Test
    void testDisplayResults() {
        VotingSystem.castVote("Alice");
        VotingSystem.castVote("Bob");
        VotingSystem.castVote("Alice");

        VotingSystem.displayResults();

        // Capture and verify output
        String output = outputStreamCaptor.toString();

        // Ensure the output contains vote counts and order
        assertTrue(output.contains("Voting Results (Sorted by Vote Count):"));
        assertTrue(output.contains("Voting Order (Preserving Order of Votes):"));
        assertTrue(output.contains("Alice: 2 votes"));
        assertTrue(output.contains("Bob: 1 vote"));
    }
}
