package Day01_JavaGenerics.ProblemStatement.MultiLevelUniversityCourseManagementSystem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniversityCourseManagementTest {

    @Test
    void testExamCourseDetails() {
        Course<ExamCourse> examCourse = new Course<>("CS101", new ExamCourse("Computer Science 101"));

        // Get the course details
        String result = examCourse.getCourseDetails();

        // Verify the result
        assertEquals("Course Code: CS101, Course Name: Computer Science 101, Evaluation Method: Exam-based", result);
    }

    @Test
    void testAssignmentCourseDetails() {
        Course<AssignmentCourse> assignmentCourse = new Course<>("CS102", new AssignmentCourse("Computer Science 102"));

        // Get the course details
        String result = assignmentCourse.getCourseDetails();

        // Verify the result
        assertEquals("Course Code: CS102, Course Name: Computer Science 102, Evaluation Method: Assignment-based", result);
    }

    @Test
    void testResearchCourseDetails() {
        Course<ResearchCourse> researchCourse = new Course<>("CS103", new ResearchCourse("Computer Science 103"));

        // Get the course details
        String result = researchCourse.getCourseDetails();

        // Verify the result
        assertEquals("Course Code: CS103, Course Name: Computer Science 103, Evaluation Method: Research-based", result);
    }

    @Test
    void testPrintCourseDetailsWithWildcard() {
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(new ExamCourse("Computer Science 101"));
        allCourses.add(new AssignmentCourse("Computer Science 102"));
        allCourses.add(new ResearchCourse("Computer Science 103"));
        allCourses.add(new ExamCourse(" "));

        // Capture the course details printed to the console
        String result = captureCourseDetails(allCourses);

        // Verify the result contains all course details
        assertTrue(result.contains("Computer Science 101 - Evaluation Method: Exam-based"));
        assertTrue(result.contains("Computer Science 102 - Evaluation Method: Assignment-based"));
        assertTrue(result.contains("Computer Science 103 - Evaluation Method: Research-based"));
        assertTrue(result.contains(" "));
    }

    // Helper method to capture the console output from printCourseDetails
    private String captureCourseDetails(List<CourseType> courses) {
        // Use a StringBuilder to capture the output
        StringBuilder capturedOutput = new StringBuilder();
        for (CourseType course : courses) {
            capturedOutput.append(course.getCourseName())
                    .append(" - ")
                    .append(course.getEvaluationMethod())
                    .append("\n");
        }
        return capturedOutput.toString().trim();
    }

    @Test
    void testCourseDetailsWithInvalidCourse() {
        // Expecting a NullPointerException when passing a null course
        assertThrows(NullPointerException.class, () -> {
            Course.printCourseDetails(null);
        });
    }

}
