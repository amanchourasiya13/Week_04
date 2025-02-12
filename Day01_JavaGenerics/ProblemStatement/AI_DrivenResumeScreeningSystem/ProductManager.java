package Day01_JavaGenerics.ProblemStatement.AI_DrivenResumeScreeningSystem;

public class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager", "Product Strategy, Roadmap Planning, Market Analysis");
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Required Skills: " + requiredSkills);
    }
}

