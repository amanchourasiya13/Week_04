package Day01_JavaGenerics.ProblemStatement.MultiLevelUniversityCourseManagementSystem;

public class ExamCourse extends CourseType {

    public ExamCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getEvaluationMethod() {
        return "Evaluation Method: Exam-based";
    }
}

