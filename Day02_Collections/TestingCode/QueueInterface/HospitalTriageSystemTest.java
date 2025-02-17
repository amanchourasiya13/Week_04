package Day02_Collections.QueueInterface;

import org.junit.jupiter.api.Test;
import java.util.PriorityQueue;
import static org.junit.jupiter.api.Assertions.*;

public class HospitalTriageSystemTest {

    // Test case to verify the correct treatment order of patients based on severity
    @Test
    public void testTreatmentOrder() {
        // Create a priority queue to hold the patients, ordered by severity (higher severity first)
        PriorityQueue<Patient> queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.severity, p1.severity));

        // Create patients with names and severity levels
        Patient p1 = new Patient("John", 3);
        Patient p2 = new Patient("Alice", 5);
        Patient p3 = new Patient("Bob", 2);

        // Add patients to the priority queue
        queue.add(p1);
        queue.add(p2);
        queue.add(p3);

        // Extract patients in the order of severity (highest first)
        Patient firstPatient = queue.poll();
        Patient secondPatient = queue.poll();
        Patient thirdPatient = queue.poll();

        // Assert the order of treatment based on severity
        assertEquals("Alice", firstPatient.name, "First treated patient should be Alice with highest severity.");
        assertEquals("John", secondPatient.name, "Second treated patient should be John with second highest severity.");
        assertEquals("Bob", thirdPatient.name, "Third treated patient should be Bob with lowest severity.");
    }

    // Test case when there are no patients in the queue
    @Test
    public void testNoPatients() {
        // Create an empty priority queue
        PriorityQueue<Patient> queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.severity, p1.severity));

        // Assert that the queue is empty
        assertTrue(queue.isEmpty(), "The queue should be empty.");

        // Try polling from the empty queue
        Patient patient = queue.poll();

        // Assert that polling from an empty queue returns null
        assertNull(patient, "Polling from an empty queue should return null.");
    }

    // Test case with a single patient in the queue
    @Test
    public void testSinglePatient() {
        // Create a priority queue with a custom comparator
        PriorityQueue<Patient> queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.severity, p1.severity));

        // Create a single patient
        Patient p1 = new Patient("John", 3);

        // Add the patient to the queue
        queue.add(p1);

        // Assert that the queue contains one patient
        assertEquals(1, queue.size(), "There should be exactly one patient in the queue.");

        // Poll the patient
        Patient patient = queue.poll();

        // Assert that the correct patient is treated
        assertEquals("John", patient.name, "The only patient should be John.");
    }
}
