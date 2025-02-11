package Day01_JavaGenerics.ProblemStatement.MultiLevelUniversityCourseManagementSystem;

public class AssignmentCourse extends CourseType {

    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getEvaluationMethod() {
        return "Evaluation Method: Assignment-based";
    }
}

