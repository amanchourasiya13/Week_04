package Day01_JavaGenerics.ProblemStatement.MultiLevelUniversityCourseManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class UniversityCourseManagement {
    public static void main(String[] args) {
        // Creating courses of different types
        Course<ExamCourse> examCourse = new Course<>("CS101", new ExamCourse("Computer Science 101"));
        Course<AssignmentCourse> assignmentCourse = new Course<>("CS102", new AssignmentCourse("Computer Science 102"));
        Course<ResearchCourse> researchCourse = new Course<>("CS103", new ResearchCourse("Computer Science 103"));

        // Print individual course details
        System.out.println(examCourse.getCourseDetails());
        System.out.println(assignmentCourse.getCourseDetails());
        System.out.println(researchCourse.getCourseDetails());

        // Dynamically handle a list of courses of any type using wildcards
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(new ExamCourse("Computer Science 101"));
        allCourses.add(new AssignmentCourse("Computer Science 102"));
        allCourses.add(new ResearchCourse("Computer Science 103"));

        // Using wildcard to handle any type of course and print course details
        System.out.println("\nCourse List with Wildcard:");
        Course.printCourseDetails(allCourses);
    }
}

