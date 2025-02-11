package Day01_JavaGenerics.ProblemStatement.MultiLevelUniversityCourseManagementSystem;

public abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public abstract String getEvaluationMethod();
}
