package Day01_JavaGenerics.ProblemStatement.AI_DrivenResumeScreeningSystem;

public abstract class JobRole {
    protected String jobTitle;
    protected String requiredSkills;

    public JobRole(String jobTitle, String requiredSkills) {
        this.jobTitle = jobTitle;
        this.requiredSkills = requiredSkills;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public abstract void displayJobDetails();
}

