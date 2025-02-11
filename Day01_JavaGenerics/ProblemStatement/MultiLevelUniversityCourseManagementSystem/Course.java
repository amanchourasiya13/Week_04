package Day01_JavaGenerics.ProblemStatement.MultiLevelUniversityCourseManagementSystem;

import java.util.List;

public class Course<T extends CourseType> {
    private String courseCode;
    private T courseType;

    public Course(String courseCode, T courseType) {
        this.courseCode = courseCode;
        this.courseType = courseType;
    }

    public String getCourseDetails() {
        return "Course Code: " + courseCode + ", Course Name: " + courseType.getCourseName() +
                ", " + courseType.getEvaluationMethod();
    }

    public static void printCourseDetails(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseName() + " - " + course.getEvaluationMethod());
        }
    }
}

