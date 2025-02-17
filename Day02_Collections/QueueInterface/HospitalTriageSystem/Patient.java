package Day02_Collections.QueueInterface.HospitalTriageSystem;

public class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Override toString for easy display
    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}