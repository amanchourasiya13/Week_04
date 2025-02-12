package Day01_JavaGenerics.ProblemStatement.AI_DrivenResumeScreeningSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ResumeScreeningSystemTest {

    private SoftwareEngineer softwareEngineer;
    private DataScientist dataScientist;
    private ProductManager productManager;

    private Resume<SoftwareEngineer> resume1;
    private Resume<DataScientist> resume2;
    private Resume<ProductManager> resume3;

    @BeforeEach
    public void setUp() {
        // Create instances of job roles
        softwareEngineer = new SoftwareEngineer();
        dataScientist = new DataScientist();
        productManager = new ProductManager();

        // Create resume instances for each role
        resume1 = new Resume<>(softwareEngineer, "John Doe");
        resume2 = new Resume<>(dataScientist, "Jane Smith");
        resume3 = new Resume<>(productManager, "Mark Johnson");
    }

    @Test
    public void testProcessResumeForSoftwareEngineer() {
        // Test processing the Software Engineer resume
        resume1.processResume();
        assertNotNull(resume1);
        assertEquals("Software Engineer", resume1.getJobRole().getJobTitle());
        assertEquals("Java, Python, Algorithms", resume1.getJobRole().getRequiredSkills());
    }

    @Test
    public void testProcessResumeForDataScientist() {
        // Test processing the Data Scientist resume
        resume2.processResume();
        assertNotNull(resume2);
        assertEquals("Data Scientist", resume2.getJobRole().getJobTitle());
        assertEquals("Machine Learning, Data Analysis, Python", resume2.getJobRole().getRequiredSkills());
    }

    @Test
    public void testProcessResumeForProductManager() {
        // Test processing the Product Manager resume
        resume3.processResume();
        assertNotNull(resume3);
        assertEquals("Product Manager", resume3.getJobRole().getJobTitle());
        assertEquals("Product Strategy, Roadmap Planning, Market Analysis", resume3.getJobRole().getRequiredSkills());
    }

    @Test
    public void testProcessMultipleResumes() {
        // Create a list of job roles
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(softwareEngineer);
        jobRoles.add(dataScientist);
        jobRoles.add(productManager);

        // Test processing multiple resumes using wildcard method
        Resume.processMultipleResumes(jobRoles);
    }
}
