package Day01_JavaGenerics.ProblemStatement.AI_DrivenResumeScreeningSystem;

import java.util.ArrayList;
import java.util.List;

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        // Create job role instances
        SoftwareEngineer softwareEngineer = new SoftwareEngineer();
        DataScientist dataScientist = new DataScientist();
        ProductManager productManager = new ProductManager();

        // Create resume instances for different roles
        Resume<SoftwareEngineer> resume1 = new Resume<>(softwareEngineer, "John Doe");
        Resume<DataScientist> resume2 = new Resume<>(dataScientist, "Jane Smith");
        Resume<ProductManager> resume3 = new Resume<>(productManager, "Mark Johnson");

        // Process individual resumes
        resume1.processResume();
        resume2.processResume();
        resume3.processResume();

        // Create a list of job roles to process multiple resumes
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(softwareEngineer);
        jobRoles.add(dataScientist);
        jobRoles.add(productManager);

        // Use wildcard method to process multiple resumes
        Resume.processMultipleResumes(jobRoles);
    }
}

