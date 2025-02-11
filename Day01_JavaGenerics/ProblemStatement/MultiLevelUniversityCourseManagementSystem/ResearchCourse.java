package Day01_JavaGenerics.ProblemStatement.MultiLevelUniversityCourseManagementSystem;

public class ResearchCourse extends CourseType {

    public ResearchCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getEvaluationMethod() {
        return "Evaluation Method: Research-based";
    }
}

