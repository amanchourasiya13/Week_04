package Day01_JavaGenerics.ProblemStatement.AI_DrivenResumeScreeningSystem;

import java.util.List;

public class Resume<T extends JobRole> {
    private T jobRole;
    private String candidateName;

    public Resume(T jobRole, String candidateName) {
        this.jobRole = jobRole;
        this.candidateName = candidateName;
    }

    //getter for job role
    public T getJobRole(){
        return jobRole;
    }
    // Process the individual resume
    public void processResume() {
        System.out.println("Processing " + jobRole.getJobTitle() + " resume for " + candidateName);
        System.out.println("Required skills: " + jobRole.getRequiredSkills());
    }

    // Static method to process multiple resumes
    public static void processMultipleResumes(List<? extends JobRole> jobRoles) {
        for (JobRole jobRole : jobRoles) {
            System.out.println("Processing resume for: " + jobRole.getJobTitle());
            System.out.println("Required skills: " + jobRole.getRequiredSkills());
        }
    }
}
