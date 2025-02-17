package Day02_Collections.QueueInterface.HospitalTriageSystem;

import java.util.PriorityQueue;
import java.util.Comparator;



public class HospitalTriageSystem {

    public static void main(String[] args) {
        // Create a priority queue to hold the patients, ordered by severity (higher severity first)
        PriorityQueue<Patient> queue = new PriorityQueue<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                // Compare patients by severity in descending order (highest severity first)
                return Integer.compare(p2.severity, p1.severity);
            }
        });

        // Create patients with names and severity levels
        Patient p1 = new Patient("John", 3);
        Patient p2 = new Patient("Alice", 5);
        Patient p3 = new Patient("Bob", 2);

        // Add patients to the priority queue
        queue.add(p1);
        queue.add(p2);
        queue.add(p3);

        // Treat patients in order of severity (highest severity first)
        System.out.println("Treatment Order:");
        while (!queue.isEmpty()) {
            Patient currentPatient = queue.poll();  // Retrieve and remove the highest priority patient
            System.out.println("Treating: " + currentPatient);
        }
    }
}
