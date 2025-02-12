package Day01_JavaGenerics.ProblemStatement.AI_DrivenResumeScreeningSystem;

public class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist", "Machine Learning, Data Analysis, Python");
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Required Skills: " + requiredSkills);
    }
}
