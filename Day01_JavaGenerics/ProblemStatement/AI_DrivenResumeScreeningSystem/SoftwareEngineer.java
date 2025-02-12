package Day01_JavaGenerics.ProblemStatement.AI_DrivenResumeScreeningSystem;

public class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer", "Java, Python, Algorithms");
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Required Skills: " + requiredSkills);
    }
}
